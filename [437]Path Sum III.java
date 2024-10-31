/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 遍历过程中用于跟踪 (前缀和PrefixSum、前缀和出现次数) 的 Map, Long是节点中的val(测试用例包含超过int范围)
    //时间复杂度O(n)
    Map<Long, Integer> hmap;
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;
        //调用dfs(深度优先)方法递归遍历二叉树
        dfs(root, 0, targetSum);
        return count;
    }
    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        // 边界判断
        if (root == null) return;
        prefixSum += root.val;//计算前缀和
        //如果map包含 前缀和减去目标数(prefixSum - targetSum)的值，count计数加该值出现的次数
        //例如节点3,1,11的前缀总和都为18, 18-8为10, 结果为 count为0 +=3 最终为3
        if (hmap.containsKey(prefixSum-targetSum)) {
            count += hmap.get(prefixSum-targetSum);
        }

        //前缀和直接等于目标和，需要增加计数, 此判断用于当满足条件的线路包含跟节点时,
        //例如targetSum为7, hmap中prefixSum - targetSum在节点2时, val为1
        //但是10+ (-3)也为7,需要返回2,这里要count计数加1
        if (targetSum == prefixSum) {
            count++;
        }
        // 更新前缀和直到当前节点和计数
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
        // System.out.println(prefixSum + " root.val= " + root.val + " count= "+count);
        // for(Long key : hmap.keySet()){
        //     System.out.println("key=" + key + " val=" + hmap.get(key));
        // }

        // 递归遍历, targetSum不是全局变量,所以要一次次传值
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);
        //回溯, 二叉树特性, 当遍历二叉树时需要遍历左右子树, 所以每个节点递归时需要把map中储存的出现次数-1
        // case 4中, 在节点-2时, prefixSum为-1, 计数+1, hmap添加key-1出现次数1,最终返回2,应该返回1
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);

    }
}

//思路有点绕, 但是更好理解, 从上往下走, 两个递归方法结合, 思路类似于嵌套循环, 比如for循环里面嵌套一个for循环
//一个递归方法是遍历寻找满足当前和的路径, 一个是遍历二叉树的每一个节点进行遍历
//时间复杂度O(n^2)
//class Solution {
//
//
//    //此方法是以当前节点为root,遍历左右子树寻找和为targetSum的次数
//    public long totalPath(TreeNode root, long targetSum) {
//        if (root == null) return 0;
//        int count = 0;
//        //如果当前节点的值等于目标和,计数加一
//        if (root.val == targetSum) {
//            count++;
//        }
//        //包含当前节点, 继续往下递归, 所以目标和需要减去当前节点的值
//        count += totalPath(root.left, targetSum - root.val);
//        count += totalPath(root.right, targetSum - root.val);
//        //返回递归结果
//        return count;
//    }
//    //此方法是递归遍历二叉树的每一个节点,
//    //每次递归时调用totalPath来遍历该节点是否包含和为targetSum的情况
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) return 0;
//        int res = 0;
//        //两个pathSum就是递归遍历整个二叉树, totalPath就是判断满足条件的次数
//        res = pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + (int) totalPath(root, targetSum);
//        //例如 example 1 中 root为10, 最终结果是3
//        //pathSum(root.left)为2,  pathSum(root.right)为1, totalPath(root)为0
//        //运行过程中, 以3 -> 3 -> 5 为例, (3,3)和(-2,3)不满足条件,3个方法都返回0
//        //运行到5时, pathSum(root.left)为0, pathSum(root.right)为0,  totalPath为2
//        //此时totalPath中, root为5, 左子树5->3时, 目标8-5=3, 计数返回1,
//        //root为5, 右子树5->2时, 目标数3, 2->1时, 目标数 3-2=1, 计数返回1, count总返回2
//        return res;
//    }
//}