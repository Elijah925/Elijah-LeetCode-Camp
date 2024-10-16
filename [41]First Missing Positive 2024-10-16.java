//Given an unsorted integer array nums. Return the smallest positive integer 
//that is not present in nums. 
//
// You must implement an algorithm that runs in O(n) time and uses O(1) 
//auxiliary space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
// 
//
// Example 3: 
//
// 
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics Array Hash Table 👍 17046 👎 1875


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 排序数组
        Arrays.sort(nums);
        int minPos = Integer.MAX_VALUE;
        // 遍历寻找数组中的最小正整数
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0 && minPos > nums[i]) {
                minPos = nums[i];
            }
        }
        // 判断minPos是否为1 , 优化方案中初始化为1就不用再次判断
        if (minPos == 1) {
            // 如果最小正数为1, 开始minPos+1
            for (int i : nums) {
                //如果右重复的就+1
                if (i == minPos) {
                    minPos++;
                }
            }
        } else {
            return 1;
        }
        return minPos;

        //优化方案 整合到1个for循环中
        // int minPos = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0 && nums[i] == minPos) {
        //         minPos++;
        //     } else if (nums[i] > minPos) {
        //         return minPos;
        //     }
        // }
        // return minPos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
