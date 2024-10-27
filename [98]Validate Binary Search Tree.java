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
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        //判断边界, root为空返回ture, case 3
        if (root == null){return true;}

        //迭代所有左树和左边节点进行判断,
        //例子2为例,  先迭代到1节点,左右子树为空,
        //1节点时候prev为null,不判断, 该次迭代只将当前节点(1)保存为"前节点(prev)"
        if(!isValidBST(root.left))
        {return false;}

        //对先前节点和当前节点对比
        //开始第二次迭代, 判断prev和当前节点(1和5)
        if (prev != null && prev.val >= root.val)
        {return false;}

        //将当前节点保存为"前节点"
        //将5保存到前节点中
        prev = root;

        //迭代判断右树
        //第二次迭代中, 当前节点为5,prev为5, 右树节点4进入迭代
        //此时当前节点为4,prev为5, 5>=4, 判断失败返回false
        if (!isValidBST(root.right))
        {return false;}

        return true;


    }
}