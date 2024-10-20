//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Sliding Window 👍 11911 👎 452


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> newMap = new HashMap<>();

        //遍历将s1字符串中所有字符和出现次数放到hashMap
        for (char C : s1.toCharArray()) {
            map.put(C, map.getOrDefault(C, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            //根据i指针位子在s2上建立一个s1长度的滑动窗口
            String subString = s2.substring(i, i + s1.length());
            for (char S : subString.toCharArray()) {
                //将每个滑动窗口添加到新的map当中
                newMap.put(S, newMap.getOrDefault(S, 0) + 1);
            }

            //如果两个map相等,那么key(字符)和value(出现次数)一样
            if (map.equals(newMap))
                return true;
            else
                newMap.clear();//初始化新map
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
