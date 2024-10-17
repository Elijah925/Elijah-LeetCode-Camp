//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 31466 👎 2943


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //建立嵌套循环,当固定索引i时,遍历左右指针求和
        for (int i = 0; i < nums.length; i++) {
            //去重,当数组内有重复数据,跳过该次循环并继续执行
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //i索引每次迭代左右指针重置
            int left = i + 1;
            int right = nums.length - 1;

            //内循环遍历求和
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                //当sum大于0时,右指针指向数据过大,移动右指针,反之同理
                //注意此时数组已经排序过,并非测试用例
                if (sum > 0) {
                    right--;
                    //这里不能用单else, 否则会包含sum=0是导致左指针依旧增加
                    //注意类似错误
                } else if (sum < 0) {
                    left++;
                }

                if (sum == 0) {
                    //注意list方法, result初始化也是list, 这里需要把array转成list
                    //注意区分asList和list的区别,
                    //此时将array转换成list之后, 该array保持数组特性,不可改变数组大小,例如添加删除
                    //参考文档: https://codegym.cc/zh/groups/posts/zh.348.java-zhong-de-arrays-aslist-fang-fa
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //当和为0,添加完结果后移动指针,继续遍历是否存在索引i时和等于0的其他情况
                    left++;

                    //内循环去重,索引i固定时,后续数组可能有重复,
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }

            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
