//Given an array of integers nums and an integer k, return the total number of 
//subarrays whose sum equals to k. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// 
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics Array Hash Table Prefix Sum 👍 22023 👎 685


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        //创建哈希表,第一个Integer是前缀和,第二个integer是出现次数
        HashMap<Integer,Integer> arr_sum = new HashMap();
        arr_sum.put(0,1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(arr_sum.containsKey(sum-k))
            {
                count+= arr_sum.get(sum-k);
            }
            if(arr_sum.containsKey(sum))
            {
                arr_sum.put(sum,arr_sum.get(sum)+1);
            }
            else
            {
                arr_sum.put(sum,1);
            }
        }



        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
