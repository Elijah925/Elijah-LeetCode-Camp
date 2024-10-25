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
    public TreeNode invertTree(TreeNode root) {
        //这个递归和最大深度不同, 是自上到下的递归
        //最大深度是自下到上
        //临时节点用来传递数值
        TreeNode temp = root;
        //判断边界
        if (root == null) {
            return root;
        }

        //第一次进入递归, root.left为2, root.right为7
        //此时2和7互换
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        //调用下一次递归函数, 层数更多同理往下调用
        //更换节点7的子节点
        invertTree(root.right);
        //更换节点2的子节点
        invertTree(root.left);
        return root;
    }
}