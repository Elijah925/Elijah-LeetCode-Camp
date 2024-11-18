public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //创建新的排列组合链表
        List<List<Integer>> res = new ArrayList<>();
        //边界判断
        if (nums.length == 0) {
            return res;
        }

        //调用递归函数, 循环遍历递归数组
        collectPermutations(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
                                     List<List<Integer>>  res) {
        //排列数组大小等于给定数组时, res添加该情况, 返回上一层递归
        if (permutation.size() == nums.length) {
            //去重
            if(res.contains(permutation)) {return;}
            res.add(permutation);
            return;
        }

        //循环递归数组, 例如[1,2,3], 第一次进入循环permutation为空,size为0
        for (int i = 0; i <= permutation.size(); i++) {
            //根据传入的排列数组新建一个排列顺序
            List<Integer> newPermutation = new ArrayList<>(permutation);
            //最开始newPermutation一样为空, 所以当i为0时, 递归三次才到size等于数组大小,才添加到res中
            //注意,这里的add方法是根据索引添加元素, 不是直接append
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, res);
        }
    }
}
// 代码示例
// nums = 1,2,3

// 第一次调用排序方法
// start = 0, permutation = []
// 第一次进入排序方法的for循环
// i = 0, newPermutation = [1]
//      for循环第一次递归
// 	    start = 1, permutation = [1]
// 	    i = 0, newPermutation = [2, 1]
//第二次进入for循环中的递归
// 		    start = 2, permutation = [2, 1]
//          nums[start] 为 3,这里newPermutation以i为索引添加 3,
//          然后permutation大小为3, 添加到res中并返回, 返回到上一层递归运行i++;

//for循环3次的结果, 每次都添加到了res中  此时第一次for循环递归完毕
// 		    i = 0, newPermutation = [3, 2, 1]
// 		    i = 1, newPermutation = [2, 3, 1]
// 		    i = 2, newPermutation = [2, 1, 3]

//      for循环第二次递归
//      此时start为1时, for循环的i=0运行完毕, permutation = [1] 继续运行 i=1
//      nums[start] 为 2,这里newPermutation以i为索引添加 2,
// 	    i = 1, newPermutation = [1, 2]
// 		    start = 2, permutation = [1, 2]
// 		    i = 0, newPermutation = [3, 1, 2]
// 		    i = 1, newPermutation = [1, 3, 2]
// 		    i = 2, newPermutation = [1, 2, 3]