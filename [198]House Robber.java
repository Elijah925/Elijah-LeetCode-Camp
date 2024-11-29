class Solution {
    public int rob(int[] nums) {
        //动态规划的思路(每一个位置保存的是抢劫到当前房屋的最大值)
        int[] dp = new int[nums.length];
        //边界判断, 只有1间房时,返回其值 
        if(nums.length <2) return nums[0];
        //两间时,返回最大值
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        //初始化动态数字前两位(因为要间隔一个进行抢劫)
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //初始化结果
        int res = Math.max(dp[0], dp[1]);

        for(int i= 2; i< nums.length;i++){
            //对比抢到当前房间的最大值和 抢到上一个房间的最大值(避免特殊情况)
            //例如[2,7,9,3,1], 抢到房间第四间房 (3) 的时候
            // 应该是    [2,7,11,11,0] 
            // 而不是    [2,7,11,10,0]
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);

            //比较当前的最大值和之前保存的最大值
            res = Math.max(dp[i], res);
        }
        return res;
    }
}