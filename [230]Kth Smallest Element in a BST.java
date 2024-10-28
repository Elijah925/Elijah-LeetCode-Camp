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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return k;
        }

        //前中后序非递归遍历都使用堆栈(stack)来保存根节点, 特点后进先出,
        //此题中序遍历, 从左到右,从下往上, 按照左中右顺序输出,
        //使用stack.pop时候为该节点的right为空,返回为当前节点的父节点
        //层序遍历使用队列queue, 先进先出, 从上到下一层一层遍历, 例题102 和 199
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        //循环遍历, 在if条件下,当node.right为空, 并且堆栈也为空跳出循环
        //node.right为空, 堆栈不为空, 返回当前节点的父节点
        //堆栈为空时,遍历完二叉树, 以case 2 为例
        //最开始堆栈内数据为 5,3,2,1 取出1,开始中序遍历
        //循环到 数据只有5时, node为取出节点5, 然后将node.right传入node中
        //此时节点为6, stack为空,重新开始大循环, 然后6节点的right为空,跳出循环
        while (node != null || !stack.isEmpty()) {

            //依次遍历左树节点到最左节点, 并将经过的节点保存到堆栈中
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //跳出上面的while内循环时,node为空

            //堆栈不为空时, 返回最后添加的节点(当前节点的父节点),第一次为null的父节点(1)
            if (!stack.isEmpty()) {
                //判断循环经过的次数,依次减少k值
                k--;

                //取出父节点, 当前节点node移动到当前节点的右树node.right
                //注意, 右节点为空时返回的是父节点的父节点为往上一层,
                //堆栈中父节点在移动到右树时候已经取出了, 所以取出3之后,遍历4的左右树之后,直接返回5
                //例如3 -> 4, 4的左右树为空, 4 -> 5
                node = stack.pop();

                //K为0时, 遍历K次返回当前节点的val
                if (k == 0) {
                    return node.val;
                }

                node = node.right;


            }
        }

        return k;
    }
}