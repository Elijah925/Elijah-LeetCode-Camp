/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 创建map储存中序数列中的值, key是序列中的值, value是索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 调用递归函数遍历数组生成节点,
        return splitTree(preorder, map, 0, 0, inorder.length - 1);
    }

    public TreeNode splitTree(int[] preorder, Map<Integer, Integer> map, int preorderIndex, int inorderLeftTree,
                              int inorderRightTree) {
        // preorderIndex初始为0, preorder的第一个元素, 也就是二叉树的根节点
        // rootValue就是根节点的值
        int rootValue = preorder[preorderIndex];

        // inorderMidValue就是根节点的值, map中值是key, value是索引
        // 这里get到的结果是value,也就是根节点在inorder中的索引
        int inorderMidIndex = map.get(rootValue);

        // 根据传入的值创建新节点, 归生成整棵树
        TreeNode root = new TreeNode(rootValue);

        // 当前根节点在inorder数组中的索引大于inorderLeftTree(0)才会有左子树
        // example 1中, 首先3进入递归, 3在inorder数组中的索引要大于0才有左子树, 这里为1
        if (inorderMidIndex > inorderLeftTree) {
            // 递归生成根节点的左节点
            // preorder(先序数组)不变, 所以preorderIndex + 1, preorder的第二个数就是根的左节点(先序遍历:根左右)
            // 根据 preorderIndex + 1 来生成下一个节点
            // 左子树用不到inorderLeftTree(这是左子树中节点的数量)
            // inorderMidIndex - 1 就是第一个左子树长度, 这里用于考虑左子树中如果有右子树的情况
            root.left = splitTree(preorder, map, preorderIndex + 1, inorderLeftTree, inorderMidIndex - 1);
        }

        // 当前根节点在inorder数组中的索引小于inorderrightTree(数组长度-1)才会有左子树
        // example 1中, 在inorder数组中, 3的索引小于20, 20的索引要小于7 才是右子树
        if (inorderMidIndex < inorderRightTree) {
            //preorderIndex是递归到当前建立的节点,
            //inorderMidIndex - inorderLeftTree , 也就是左子树中节点数量, (该解法没有分裂数组),preorder始终没变
            // preorderIndex + inorderMidIndex - inorderLeftTree + 1 也就是不断往右走preorder数组(右子树部分)
            root.right = splitTree(preorder, map, preorderIndex + inorderMidIndex - inorderLeftTree + 1,
                    inorderMidIndex + 1, inorderRightTree);
        }
        return root;
    }
}