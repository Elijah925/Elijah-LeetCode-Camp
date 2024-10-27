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
    int count =0;
    public boolean isValidBST(TreeNode root) {
        //解题的核心逻辑用递归方法, 从左到右,从下到上进行判断,
        //prev总是在当前节点的左边,所以判断条件为prev>root
        //即左边的节点一点要小于右边节点

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

        if (prev != null){
            System.out.println("prev= "+prev.val+", root= "+root.val);
        }

        //将当前节点保存为"前节点"
        //将5保存到前节点中
        prev = root;
        count++;
        System.out.println(count);
        //迭代判断右树
        //第二次迭代中, 当前节点为5, prev为5, 右树节点进入递归
        //进入递归后此时当前节点为3, prev为5, 5>=3, 判断失败返回false
        //逻辑为进入遍历右子树时,从右子树的最左最下叶节点开始判断
        //case 4中, 3<5, 然后5<6, 然后6<7
        //第四次递归prev为7, 进入7的右节点4,失败返回
        if (!isValidBST(root.right))
        {return false;}

        return true;


    }
}