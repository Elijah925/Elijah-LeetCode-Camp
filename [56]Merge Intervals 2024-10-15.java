//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics Array Sorting 👍 22521 👎 806


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //对数组进行排序
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //需要动态添加删除所以创建链表
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){

            int[] compareArray = merged.getLast();

            //compareArray[1] 最后一个区间数组的右边界, intervals[i][0] 下一个对比数组的左边界
            //if判断是否有重叠区间
            if(compareArray[1] >= intervals[i][0]){
                //取两个右边界的最大值
                //compareArray元素是浅拷贝,更改时merged列表里最后一个区间数组的右边界一起更改了
                compareArray[1] = Math.max(compareArray[1],intervals[i][1]);
            }
            else{
                merged.add(intervals[i]);
            }
        }

        // 二维数组的实例方法需要返回二维数组
        return merged.toArray(new int[merged.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
