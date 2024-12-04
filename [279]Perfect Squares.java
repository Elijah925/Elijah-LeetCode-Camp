class Solution {
    public int numSquares(int amount) {
        //322题相同思路, 循环条件略难

        // 创建大小为amount+1的数组,因为有第0个索引
        int[] dp = new int[amount + 1];
        // dp[i] 表示凑成数字 i 所需的最少平方数个数
        // 平方数最小值为1, 所以最少硬币数一定小于amount+1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        //外循环遍历amount次, 从1开始到amount更新每个数字的最少平方数个数
        for (int i = 1; i < amount + 1; i++) {
            //内循环遍历每一个平方数, (平方数的平方需要小于i)
            for (int j = 1; j * j <= i; j++) {
                // 索引值为达到该数的最少平方数, 1 + dp[i - j*j]中 +1是因为使用了当前数
                //例如 13 - 2*2 = 9, 
                //1 + dp[9] 和 dp[13] 取大小
                dp[i] = Math.min(dp[i], dp[i-j*j] +1);
            }
        }

        return dp[amount];
    }
}