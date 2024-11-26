class Solution {
    // public int maxSubArray(int[] nums) {
    // //sum是一段subarray的和
    // int sum =0;
    // int result = nums[0];

    // for(int i=0;i<nums.length;i++){
    // //取最大值,从头开始计算,当数字小于零时放弃该区间(在这里是前三位和小于0被抛弃)
    // //正结果已经存到result中
    // if(sum<0){sum=0;}

    // //计算从第一个正区间开始到第i位的和
    // //例如第一个正数是1,加到-3被放弃,-3也放弃,然后到4
    // //测试用例 [-2,1,-3,4,-1,2,1,-5,4]
    // //sum测试用例中为 -2 1 -2 4 3 5 6 1
    // sum+=nums[i];

    // //System.out.println(sum);
    // //取result和sum的最大值赋值到result
    // result = Math.max(result,sum);
    // }
    // return result;
    // }

    public int maxSubArray(int[] nums) {
        //动态规划解法
        //创建和nums长度相同的数组
        int dp[] = new int[nums.length];

        //第一个位置的最大子数组和是 nums[0]
        int max = nums[0];
        dp[0] = nums[0];

        //从第二个数开始循环
        for (int i = 1; i < nums.length; i++) {
            // dp[i] 为以第 i 个元素结尾的最大子数组和
            //因为每个数都是从头到i索引处的最大子数组和
            //所以只需要对比大小时候, 比当前索引处的值和前一个索引处的值, 也就是 i 和 i-1
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            //max取当前dp[i] 和 max的最大值
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
