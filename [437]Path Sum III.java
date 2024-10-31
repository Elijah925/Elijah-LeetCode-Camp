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
    // 遍历过程中用于跟踪 (PrefixSum、timesPrefixSumSeen) 的 Map
    Map<Long, Integer> hmap;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        // 边界判断
        if (root == null) return;


        prefixSum += root.val;

        // 如果 map 包含的总和等于 (prefixSum - targetSum)，需要将 count 增加次数
        if (hmap.containsKey(prefixSum-targetSum)) {
            count += hmap.get(prefixSum-targetSum);
        }

        //前缀和直接等于目标和，需要增加计数
             if (targetSum == prefixSum) {
            count++;
        }

        // 更新前缀和直到当前节点和计数
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        // 递归
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // 回溯
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);

    }
}