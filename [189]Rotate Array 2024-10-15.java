//Given an integer array nums, rotate the array to the right by k steps, where 
//k is non-negative. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three 
//different ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// Related Topics Array Math Two Pointers 👍 18408 👎 2007


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {

        // for(int j=0;j<k;j++){
        //     int[] result =  nums.clone();
        //     int c=result[nums.length-1];
        //     for(int i=nums.length-1;i>0;i--){
        //         nums[i] = result[i-1];
        //         if(i==1){nums[0] = c;}
        //     }
        //     System.out.println(c);
        // }

        //计算当K大于数组长度,需移动次数
        if(k > nums.length){
            k=k%nums.length;
        }

        int[] result=new int[nums.length];
        int j=0;

        //将原数组从头开始复制到result数组从第K位
        for(int i=k;i<nums.length;i++){
            result[i]=nums[j];
            j++;
        }

        //将原数组第K位,复制到resutl数组从头开始
        for(int i=0;i<k;i++){
            result[i]=nums[j];
            j++;
        }

        System.arraycopy( result, 0, nums, 0, nums.length );
    }
}
//leetcode submit region end(Prohibit modification and deletion)
