class Solution {
    public String minWindow(String s, String t) {
        //判断边界案例
        if (t.length() > s.length()) {
            return "";
        }

        //建立需要对比字符的哈希表
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        //初始化滑动窗口
        //string不好定义指针,在循环中定义(局部定义)的话不好返回,
        int[] minWindow = {0, Integer.MAX_VALUE};
        int left = 0;
        int count = t.length();

        for(int right = 0;right<s.length();right++) {
            //检查哈希表中对应value
            char rChar = s.charAt(right);
            if (map.containsKey(rChar) && map.get(rChar)>0) {
                count--;
            }
            //右指针移动时,s字符串中所有字符先-1
            map.put(rChar, map.getOrDefault(rChar,0) - 1);

            //此时是找到第一个符合窗口后
            if (count == 0) {

                while(true){
                    char leftChar = s.charAt(left);
                    //左移左指针,直到指向S中的字符是包含在t中的字符
                    if(map.containsKey(leftChar) && map.get(leftChar) == 0){
                        break;
                    }
                    //非t中字符val为-1, 现在补成0
                    map.put(leftChar, map.getOrDefault(leftChar,0) + 1);
                    left++;
                }

                //判断左右指针距离,取小值
                if (right - left < minWindow[1] - minWindow[0]) {
                    minWindow[0] = left;
                    minWindow[1] = right;
                }

                //根据左指针增加t中字符需要检查的次数
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0) + 1);
                left++;
                count++;
            }
        }
        //三元表达式 窗口长度(初始化为int最大值了)
        // 当窗口长度大于s字符串长度时, 没有符合的substring, 直接返回空字符(例子3)
        // 否则返回窗口指向的substring
        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}