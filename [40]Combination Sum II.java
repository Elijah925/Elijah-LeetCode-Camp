class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //先排序,这样回溯时, 当前数大于目标就可以直接return
        Arrays.sort(candidates);
        // 调用回溯函数
        backTracking(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    public static void backTracking(List<List<Integer>> res, List<Integer> combList, int[] candidates, int target, int index) {
        // 找到目标组合,添加到res中
        if (target == 0) {
            // System.out.println(combList.toString());
            res.add(new ArrayList<Integer>(combList));
            return;
        }

        //根据传递过来的索引index开始回溯candidates后续的值
        for (int i = index; i < candidates.length; i++) {
            //如果i>index说明candidates[index]的情况已经遍历过了, 此时是第二次遍历
            //第二次遍历时, 如果当前值和前一个索引的值相同, 跳过该循环,
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            //如果当前元素大于target直接return(数组已经排序过了)
            if(candidates[i]>target){return;}

            // 添加元素到组合中
            combList.add(candidates[i]);
            // 回溯, 将包含当前元素值的所有情况(target==0)全部保存到res中
            backTracking(res, combList, candidates, target-candidates[i], i+1);

            // 删除最后一个导致target小于0的元素
            combList.remove(combList.size() - 1);
        }

    }

}
/*
 * 回溯问题通用参考及模板
 * https://leetcode.com/problems/combination-sum/solutions/16502/a-general-
 * approach-to-backtracking-questions-in-java-subsets-permutations-combination-
 * sum-palindrome-partitioning/
 */
