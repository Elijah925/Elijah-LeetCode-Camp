//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 12474 👎 343


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
        int sLen = s.length();
        int pLen = p.length();

        //遍历将P字符串中所有字符和出现次数放到hashMap
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        //初始化左右指针,和需要对比的字符数量(不包含重复)
        int toBeMatched = map.size();
        int left = 0;
        int right = 0;

        while (right < sLen) {
            char rChar = s.charAt(right);
            //检查右指针指向元素是否包含在map中
            if (map.containsKey(rChar)) {
                //获取改元素需要再子字符串中出现的次数
                int count = map.get(rChar);
                //如果值为1, 需要对比的字符数-1
                if (count == 1) {
                    toBeMatched--;
                }
                //减少对应元素在map当中对应的值
                map.put(rChar, count - 1);
            }
            right++;

            if (right - left > pLen) {
                //当if成立时, 检查完前pLen的字符串,并且right在后1位索引处
                char sChar = s.charAt(left);
                if (map.containsKey(sChar)) {
                    //检查左指针指向元素在map中对应计数
                    int count = map.get(sChar);
                    if (count == 0) {
                        toBeMatched++;
                    }
                    map.put(sChar, count + 1);
                }
                left++;
            }
            if (toBeMatched == 0) {
                result.add(left);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
