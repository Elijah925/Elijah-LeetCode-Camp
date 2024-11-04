class Solution {
    public boolean isValid(String s) {
        //利用栈的特性(先进后出), 和要求的第二点,正确顺序的闭合, 所以栈的第一个pop元素和第一个右括号要对得上
        Stack<Character> stack = new Stack<>();

        //循环遍历数组
        for (int i = 0; i < s.length(); i++) {
            //创建放入堆栈的字符
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                //判断是否为左括号
                stack.push(c);
            }
            else {
                //走到else如果为空, 说明到第一个右括号时, 没有左括号, 返回false 
                if(stack.isEmpty()) return false;
                //创建堆栈取出的左括号字符
                char left = stack.pop();
                // c是非左括号字符, 判断stack的第一个出战字符中是否组成完整括号
                //需要判断不为完整括号才返回, 如果为完整括号需要继续遍历, 后续有可能出现不完整情况
                // 例如 "()[]}", 最后一个大括号没有左括号, 
                if(c == ')' && left != '(') return false;
                if(c == ']' && left != '[') return false;
                if(c == '}' && left != '{') return false;
            }
        }
        //出for循环之后, 如果stack不为空, 说明还有左括号没有对应右括号闭合
        return stack.isEmpty();
    }
}