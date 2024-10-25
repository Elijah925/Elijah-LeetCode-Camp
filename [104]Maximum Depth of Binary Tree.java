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
    public int maxDepth(TreeNode root) {
        //递归法
        int deep = 0;
        if(root ==null){return 0;}

        //maxDepth(root.left)返回结果为1, 总深度为1+1(root节点) 为2
        //maxDepth(root.right)结果为2
        //递归到15或7的时, 没有叶节点, 返回0+1,
        //往上到20时, 返回1+1 为2
        //在return到root节点,返回2+1 最大长度为3
        deep = Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
        return deep;
    }
}