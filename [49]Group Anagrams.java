//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: strs = ["eat","tea","tan","ate","nat","bat"] 
// 
//
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// Explanation: 
//
// 
// There is no string in strs that can be rearranged to form "bat". 
// The strings "nat" and "tan" are anagrams as they can be rearranged to form 
//each other. 
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged 
//to form each other. 
// 
//
// Example 2: 
//
// 
// Input: strs = [""] 
// 
//
// Output: [[""]] 
//
// Example 3: 
//
// 
// Input: strs = ["a"] 
// 
//
// Output: [["a"]] 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 19604 👎 646


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //时间复杂度为 n*m*log(m)
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList();
        //判断边界
        if (strs.length == 1) {
            list.add(strs[0]);
            result.add(list);
            return result;
        }
        //复制数组, clone不会更改strs内数据
        String[] temp = strs.clone();
        //遍历排序,将数组内所有字符串进行排序,例如eat和tea排序后都是aet
        for (int i = 0; i < strs.length; i++) {
            char[] char1 = temp[i].toCharArray();
            Arrays.sort(char1);
            temp[i] = String.valueOf(char1);
        }

        //遍历所有字符串, 字符串相等时添加到列表
        //添加内循环(j)是因为,添加i会导致字符串重复添加,无法添加下一个
        //例如运行到ate时, 结果为eat*3, 而不是3个字符串
        //System.out.println(list + " j= " + j + " s= " + strs[j] + " i= " + i + " s= " + strs[i]);
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (temp[i].equals(temp[j])) {
                    list.add(strs[j]);
                }
            }
            //查重,不重复添加相同的list
            if(!result.contains(list)){
                result.add(list);
            }
            //初始化list, clear方法会清空引用,导致result也为空
            list = new ArrayList();
        }
        return result;
    }
}

//使用哈希表优化案例, 时间复杂度为 n*log(m), 遍历n次,每次遍历时排序log(m)
//将sort后字符串作为key, 符合条件的字符串作为value(string数组)
//map中不包含排序后字符串时,添加新key (这里没有添加value)
//57行对所有遍历的字符串对应的key添加value

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
//         for (String word : strs) {
//             char[] chars = word.toCharArray();
//             Arrays.sort(chars);
//             String sortedWord = new String(chars);
//             if (!map.containsKey(sortedWord)) {
//                 map.put(sortedWord, new ArrayList<>());
//             }
//             map.get(sortedWord).add(word);
//         }
//         return new ArrayList<>(map.values());
//     }
// }
//leetcode submit region end(Prohibit modification and deletion)
