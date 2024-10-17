//Given an integer array nums, move all 0's to the end of it while maintaining 
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// 
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 17061 👎 484


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        //notZero是第一个非零数字的索引, 初始化为0
        int notZero = 0;

        //遍历数组, 将所有非零数字传递到notZero索引处,notZero自增
        //notZero可以理解为变相的count非零数字
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[notZero] = nums[i];
                notZero++;
            }
        }

        //第一遍循环后,所有非零数在数组内从前往后排, 数组末尾可能出现空白, 用0填补
        for (int i = notZero; i < n; i++) {
            nums[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
