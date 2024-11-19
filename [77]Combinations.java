class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 调用回溯函数
        backTracking(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    public static void backTracking(List<List<Integer>> res, List<Integer> combList, int start, int n, int k) {
        // 当K为0, combList大小为k, res添加该情况
        // 等同于46,47题中回溯判定数组大小(另一种实现方法)
        if (k == 0) {
            //System.out.println(combList.toString());
            res.add(new ArrayList<Integer>(combList));
            return;
        }

        /*
         * 这里使用i <= n - k + 1 (不能用 i < n - k + 1),等于的时候需要再次递归,用if添加列表到结果中
         * 当你知道剩下的数字不足以n填满所需的k位置时，你不应该继续探索（递归）。
         * 如果 n = 10、k = 5，并且你处于递归的最外层，
         * 则只能选择 i = 1...6 ，因为如果你选择 i=7 并进入，backTracking()你只有 8,9,10 可供选择，
         * 所以最多你会得到 [7,8,9,10]..., 但我们需要 5 个元素！
         */
        for (int i = start; i <= n - k + 1; i++) {
            // 将 i 添加到list中,(从1开始)
            combList.add(i);
            //回溯遍历
            backTracking(res, combList, i + 1, n, k - 1);
            //删除最后一个元素
            combList.remove(combList.size() - 1);

        }

    }
}

/*
代码示例
nums = 1,2,3

第一次进入backTracking
start = 1,  combList = [] , k =2
    第一次进入for循环(最外层)
    combList 添加1 此时 combList = [1]
        进入combList为 1 时的第一次for循环的backTracking
        combList = [1], k = 2
            调用start = i + 1 = 2, combList = [1], k -1 = 1的backTracking
            combList添加 start = 2, 此时combList = [1,2]
            下一次调用backTracking时, k-1为0, 进入if语句
            res添加[1,2], return 跳出backTracking 递归
            combList删除最后一个元素, 此时 combList = [1] 
        
        进入combList为 1 时的第二次for循环的backTracking
        combList = [1], k = 2 , 注意此时i++后 i为3了
            调用start = i = 3, combList = [1], k -1 = 1的backTracking
            下一次调用backTracking时, k-1为0, 进入if语句
            res添加[1,3], return 跳出backTracking 递归
            combList删除最后一个元素, 此时 combList = [1] 

        进入combList为 1 时的第三次for循环的backTracking
            res添加[1,4], return 跳出backTracking 递归
            combList删除最后一个元素, 此时 combList = [1] 

        此时i++为4, 跳出进入combList为 1 时的for循环, combList删除最后一个元素, combList = [] 
    

    第二次进入for循环(最外层)
        进入combList为 2 时的第一次for循环的backTracking
        combList = [2], k = 2
            调用start = i + 1 = 3, combList = [2], k -1 = 1的backTracking
            combList添加 3 , 此时combList = [2,3]
            下一次调用backTracking时, k-1为0, 进入if语句
            res添加[2,3], return 跳出backTracking 递归
            combList删除最后一个元素, 此时 combList = [2] 

        进入combList为 2 时的第二次for循环的backTracking
            res添加[2,4], return 跳出backTracking 递归
            combList删除最后一个元素, 此时 combList = [2] 
        此时i++为4, 跳出for循环, combList删除最后一个元素, combList = [] 
    
    继续第三次进入for循环(最外层) 回溯 combList 为 4 的所有情况
*/