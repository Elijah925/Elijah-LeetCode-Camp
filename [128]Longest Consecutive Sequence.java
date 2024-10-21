//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array Hash Table Union Find 👍 20492 👎 1059


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        //边界
        if (nums.length <= 1) {
            return nums.length;
        }

        //复制数组到set中, 查询数据时间复杂O(1)
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        int maxLength = 0;
        //循环数组
        for (int num : nums) {
            //不包含num-1时为该数据段的最小值
            if (!set.contains(num - 1)) {
                //初始为1, 长度仅当前数字, num+1不包含在set中
                int cur_length = 1;

                //判断当前数字的连续元素序列的最大长度
                //例如, 例子1中, num=1时, 长度(cur_length)也为1
                //判断1+长度 2存在在set中, 长度++, 结果为2
                //判断1+长度 3存在在set中, 长度++, 结果为3
                //判断1+长度 4存在在set中, 长度++, 结果为4
                while (set.contains(num + cur_length)) {
                    cur_length++;
                }
                //取最大值
                maxLength = Math.max(cur_length, maxLength);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
