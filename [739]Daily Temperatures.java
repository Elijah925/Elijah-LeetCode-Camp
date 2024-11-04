class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        //初始化数组长度为temperatures长度, (此时数组内默认全是0)
        int[] result = new int[temperatures.length];
        //循环遍历数组
        for (int i = 0; i < temperatures.length; i++) {
            //注意学习双条件循环语句, 第一次进入循环, stack为空不进入内循环
            //对每一个数组中的数和前一个数进行比较, peek获取堆栈的第一个元素但不取出
            //如果索引i的温度大于堆栈中的第一个元素(最后一个没找到更高温度的索引)
            //例如 在例子1中, 运行到72时, 69那天加1, 71那天+2, 75保留在stack中继续运行for循环
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                //pop取出stack的第一个元素(索引)
                int index = stack.pop();
                //当前温度的下一个更高温度就是索引的差值
                result[index] = i- index;
            }

            //将每一个温度的索引放入堆栈, 每一次对比后符合条件的都在循环pop出过了, 
            //最后stack剩下的就是之后没有更高温度的索引, 创建数组时默认为0了
            stack.push(i);
            // System.out.println("i= " +i +" stack= "+stack.peek());
        }

        return result;
    }
}