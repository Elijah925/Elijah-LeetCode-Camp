class Solution {
    public String decodeString(String s) {
        //创建栈存放子字符串出现次数
        Stack<Integer> intStack = new Stack<>();
        //StringBuilder用于处理可变字符串 (遍历过程中没出现括号需要一直改变子字符串内容)
        //给定字符串可能出现嵌套情况,例子2, 所以需要用到堆栈保存
        Stack<StringBuilder> subStringStack = new Stack<>();
        //每个括号中间的子字符串, 算上计数后, 放入字符堆栈中, 最后为result
        StringBuilder subString = new StringBuilder();
        int count = 0;

        //遍历数组
        for (char c : s.toCharArray()) {
            //判断子字符是否为数字
            if (Character.isDigit(c)) {
                //数字可能大于10,所以需要计算,  char转int需要减去 '0'
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                //出现左括号时, count已经获取到子字符串出现的完整次数, 放到数字堆栈中
                intStack.push(count);
                count = 0;
                //第一个左括号时为空, 后进先出,所以不影响
                subStringStack.push(subString);
                //重置subString内容
                subString = new StringBuilder();
            } else if (c == ']') {
                //出现右括号时, 需要计算该括号中的字符串,
                int k = intStack.pop();
                //将这次循环闭合的括号的内容放入到temp中循环添加,
                StringBuilder temp = subString;
                //取出堆栈中的保存的字符,非嵌套情况为空
                subString = subStringStack.pop();
                System.out.println("subString= "+subString + " temp= " +temp);
                //以例子2为例, 第一个右括号时, temp为c, subString为a, 循环为字符a 加c*k
                while (k-- > 0) {
                    subString.append(temp);
                }

            } else {
                //不满足以上条件, 非数字左右括号时, 子字符串扩展添加
                subString.append(c);
            }
        }

        return subString.toString();
    }
}


