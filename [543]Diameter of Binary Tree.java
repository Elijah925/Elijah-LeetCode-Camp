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
    //解题核心, 需要得到左右子树的最大高度, 并且计算最大高度的和(最大宽度)
    //递归方法求高度需要返回该节点的最大高度数值(左右子树某一边),所以无法求和
    //所以要将求高度的代码放到新方法中进行递归,

    //全局变量width为最大宽度
    int width = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //边界判断
        if (root == null) {
            return 0;
        }
        //求当前节点的高度, 在方法中更新该节点的最大宽度
        maxDepth(root);
        return width;
    }

    public int maxDepth(TreeNode root) {
        //递归法
        if(root ==null){return 0;}

        //同104题,求最大高度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //左边最大高度+右边最大高度,为该节点的最大宽度
        //每次递归进行对比, 更改width为目前最大宽度
        width = Math.max(left+right, width);
        return Math.max(left,right) +1 ;
    }
}