class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //用length + 1 为了方便理解位置, 参考substring(i,j)方法

        //同理这就是为什么dp[0] 要初始化为true, 
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //外层循环 i 遍历从 1 到 s.length()，i代表子字符串数量
        //substring(0,4), 代表的是0,1,2,3的4个字符, 所以i可以等于s.length
        //这里是逐步扩展子字符串的长度，依次检查 s 的每个前缀是否满足条件, 
        //例如 i = 3时, 检查leetcode中lee是否满足条件
        for (int i = 1; i <= s.length(); i++) {
            //对于每一个子字符串遍历字典
            for (String w : wordDict) {
                //start 单词 w 在 s 中的起始位置
                int start = i - w.length();    
                /*  start >= 0
                    确保起始位置start不能小于0, 也就是w单词不能超过当前子字符串大小
                    dp[start]
                    检查 s.substring(0, start) 是否已经可以被字典拼接而成
                    也是为什么dp[0]要设置为true的原因
                    例如leetcode中,
                    i=4的时, start为0, dp[start]为true, 才会检查leet
                    加入字符串是leeecode
                    i=4时,leee不符合条件,不进if
                    运行到i=8, dp[4] 还是false, 不会进入判断code
                */
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //如果最后一个布尔值为true, 说明符合条件
        return dp[s.length()];
    }
}