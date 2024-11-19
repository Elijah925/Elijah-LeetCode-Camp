class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 调用回溯函数
        backTracking(res, new ArrayList<Integer>(), candidates, target, 0, 0);
        return res;
    }

    public static void backTracking(List<List<Integer>> res, List<Integer> combList, int[] candidates, int target, int sum, int index) {
        /*解题思路:
            第一个递归找判断边界情况, 同时将包含最多当前数的情况放入到结果数组
            第二个递归将当前元素一个个的移除,添加后续元素,
            两个递归下来则遍历完了所有包含当前元素的可能性
            注意, 这思路有一点取巧, 得到的candidates数组需要是排序后的情况
        */

        // 找到目标组合,添加到res中
        if (sum == target) {
            // System.out.println(combList.toString());
            res.add(new ArrayList<Integer>(combList));
            return;
        }
        //如果当前和大于目标数,或者索引超出范围, 这条路线行不通, 返回上一个交叉口
        if (sum > target || index >= candidates.length) {
            return;
        }

        //添加元素到组合中
        combList.add(candidates[index]);

        // 回溯遍历 只包含当前元素的情况是否可以满足目标数(当前元素*N = target 或 当前元素 = target)
        backTracking(res, combList, candidates, target, sum + candidates[index], index);

        // 删除最后一个导致sum大于target的元素, 例如example 1中
        // combList[2,2,2,2] 大于7, 删除最后一个2, 此时 combList[2,2,2]
        combList.remove(combList.size()-1);

        // 回溯遍历 包含最多当前数且不大于目标数时, 添加下一个数, 
        // 例如,combList[2,2,2] 添加3 
        backTracking(res, combList, candidates, target, sum, index + 1);
    }

}
/*
    思路参考
    https://www.youtube.com/watch?v=inKd43aUqF0&ab_channel=CodingNinja

    回溯问题通用参考及模板
    https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
*/
