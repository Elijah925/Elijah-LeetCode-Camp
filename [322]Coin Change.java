class Solution {
    public int coinChange(int[] coins, int amount) {
        // 边界案例, 如果amount为0时返回0
        if (amount == 0)
            return 0;

        // 创建数组,(大小为amount+1)因为有第0个索引, 索引为amount
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // 创建 dp 数组，大小为 amount + 1，初始值为 amount + 1
        // dp[i] 表示凑成金额 i 所需的最少硬币数
        // 硬币最小值为1, 所以最少硬币数一定小于amount+1
        for (int i = 1; i < amount+1; i++) {
            dp[i] = amount + 1;
        }

        // 外循环遍历amount次, 从1开始更新每个金额的最少硬币数
        for (int i = 1; i < amount + 1; i++) {
            // 内循环遍历每一个硬币,更新最小硬币数
            for (int coin : coins) {
                // 当i-c<0时, 代表当前硬币值大于amount,跳过该情况
                if (i - coin >= 0) {
                    // 索引值为达到该金额的最少硬币数, 1 + dp[i - coin]中 +1是因为使用了当前硬币
                    //例如amount=5, coins = [1,2,5]
                    /*当遍历到4时, 
                        用coin = 1; 
                        dp[4] = 6, i - coin = 3, dp[3] = 2
                        对比 6 和 2+1 , 此时dp[4] 为3
                        
                        用coin = 2; 
                        dp[4] = 3, i - coin = 2, dp[2] = 1;
                        对比 6 和 1+1 , 此时dp[4] 为2

                        用coin = 3; dp[4] == 3
                        dp[4] = 2, i - coin = 1, dp[1] = 1;
                        对比 2 和 2+1 , 此时dp[4] 为2
                    */
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        //对比amount的最小硬币数是否更新, 对应返回
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}