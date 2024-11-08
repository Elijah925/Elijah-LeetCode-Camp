class Solution {
    //这解法是用boolean值传递参数, 将二分法找左右边界融合到一个方法内
    //日常练习要熟悉使用第二个, 二分法模板
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // 调用二分查找方法找左右指针, boolean值为了传递到方法内判断找左边界还是右边界
        // 这里ture是找左边界(自己定), 使用在最后一个else语句
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        //idx为符合target的边界值索引
        int idx = -1;

        //创建循环, 当左边界大于有边界时循环完全部可能性, 思路类似双指针
        //每次移动时, 根据中间值mid来移动左右指针,所以是二分法, 实现复杂度O(logN)
        while (left <= right) {
            //中间索引mid (注意int忽视小数)
            int mid = left + (right - left) / 2;
            //根据中间索引的值移动左右指针, 中间值大, 说明target在左边, 移动右指针
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            //中间值等于target时进入else, 这里并没有跳出循环, 继续运行直到left>right
            //idx 0,1,2,3,4,5,6,7,8,9       target为8
            // 以{2,3,4,7,8,8,8,8,8,10}为例, 第一次中间值为4,保存到idx
            //继续运行while循环寻找下一个索引, 此时因为剩下的所有数字都小于8, 循环时一直移动左指针
            //直到最后没有满足条件的, 返回idx
            else {
                //先保存索引 (有时中间索引刚好为寻找的边界索引)
                idx = mid;
                //如果是true, 寻找左边界,移动右指针
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return idx;
    }
    //https://www.youtube.com/watch?v=441pamgku74&ab_channel=CodingNinja
}


//二分查找发模板
// public class Solution {
// public int[] searchRange(int[] nums, int target) {
//     int[] result = new int[2];
//     result[0] = findFirst(nums, target);
//     result[1] = findLast(nums, target);
//     return result;
// }
// private int findFirst(int[] nums, int target){
//     int idx = -1;
//     int start = 0;
//     int end = nums.length - 1;
//     while(start <= end){
//         int mid = (start + end) / 2;
//         if(nums[mid] >= target){
//             end = mid - 1;
//         }else{
//             start = mid + 1;
//         }
//         if(nums[mid] == target) idx = mid;
//     }
//     return idx;
// }
// private int findLast(int[] nums, int target){
//     int idx = -1;
//     int start = 0;
//     int end = nums.length - 1;
//     while(start <= end){
//         int mid = (start + end) / 2;
//         if(nums[mid] <= target){
//             start = mid + 1;
//         }else{
//             end = mid - 1;
//         }
//         if(nums[mid] == target) idx = mid;
//     }
//     return idx;
// }



//暴力解法, 时间复杂度O(N)
// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] result = { -1, -1 };
//         int left = 0;
//         int right = nums.length - 1;
//         int count = 0;
//         while (left <= right && count < nums.length) {
//             if (target == nums[left]) {result[0] = left;} 
//             else {left++;}
//             if (target == nums[right]) { result[1] = right;} 
//             else { right--;}            
//             count++;
//         }
//         return result;
//     }
// }