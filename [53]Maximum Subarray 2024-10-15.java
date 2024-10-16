//Given an integer array nums, find the subarray with the largest sum, and 
//return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
//
// Related Topics Array Divide and Conquer Dynamic Programming 👍 34523 👎 1465


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxSubArray(int[] nums) {
        //sum是一段subarray的和
        int sum =0;
        int result = nums[0];

        for(int i=0;i<nums.length;i++){
            //取最大值,从头开始计算,当数字小于零时放弃该区间(在这里是前三位和小于0被抛弃)
            //正结果已经存到result中
            if(sum<0){sum=0;}

            //计算从第一个正区间开始到第i位的和
            //例如第一个正数是1,加到-3被放弃,-3也放弃,然后到4
            //测试用例      [-2,1,-3,4,-1,2,1,-5,4]
            //sum测试用例中为 -2 1 -2 4  3 5 6  1
            sum+=nums[i];


            //System.out.println(sum);
            //取result和sum的最大值赋值到result
            result = Math.max(result,sum);
        }

        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
