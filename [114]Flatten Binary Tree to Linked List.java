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
    public void flatten(TreeNode root) {
        //边界
        if(root == null) return;

        //遍历二叉树左右子树
        flatten(root.left);
        flatten(root.right);

        //if第一次运行为节点3,返回节点2
        //此时root为2,left为3, 节点3没有右子树,不进人while循环
        //将4接入到节点3的右子树,将3接到2的右子树
        //--参考 case 4 的用例视图,实现逻辑为先序遍历时,
        //左子树中的右节点依次接入到最左的节点中(4接入到3),以此类推
        //然后从节点3开始返回,变成父节点的右节点,(3接2的右),左导入null

        //此时所有左子树遍历完, 进入右子树,
        //节点6左右子树为空返回到节点5,节点5左子树空返回1(案例1)
        //                           节点5左子树6,就将6接入5的右边(case4)
        //达到节点1的循环时, 进入while语句, 达到左子树的最右节点(5接入到4)
        if(root.left != null) {
            TreeNode left = root.left;

            while(left.right != null) {
                left = left.right;
            }

            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}