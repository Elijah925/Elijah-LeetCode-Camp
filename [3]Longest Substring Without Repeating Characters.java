//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 40411 👎 1944


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int lenght = 0;

        // left代表计算字字符串长度时第一个非重复字符的索引
        int left = 0;

        // hashset有无序性和不可重复性
        HashSet<Character> count = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // 当字符出现重复时, 将从上一次计算长度时的字字符串的第一个字符开始删除
            // 例如 遍历到abca时, 运行结果为bca
            // 注意不是只删除重复的
            // 比如遍历到abcb时, left指针指向字符a, 从a开始删除, 运行结果为cb
            while (count.contains(s.charAt(i))) {
                count.remove(s.charAt(left));
                left++;
            }

            // while循环后将前缀中从头删除到与i索引处字符相同的地方,
            // 此时将i处字符重新添加到字符集当中
            count.add(s.charAt(i));
            // 重新计算子字符串的长度,和之前保存的长度取最大值
            // +1是因为i和left代表索引(指针),从0开始
            lenght = Math.max(lenght, i - left + 1);

        }
        return lenght;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
