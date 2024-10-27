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
    public List<Integer> rightSideView(TreeNode root) {
        //基本与102相同, 需要考虑极端情况
        //比如右子树有3层, 左子树5层或更多,需要返回每层的最右节点,

        // 初始化返回列表
        List<Integer> result = new ArrayList<>();
        // 判断边界
        if (root == null) {
            return result;
        }

        // 队列特性, 先进先出, 用以保存节点
        Queue<TreeNode> que = new LinkedList<>();
        // 将根节点默认添加到队列中
        que.add(root);

        // 判断放入和取出队列的次数,
        int take = 0;
        int push = 1;

        // 队列不为空时往后循环
        while (!que.isEmpty()) {
            // poll取出并删除第一个元素
            TreeNode temp = que.poll();
            // 自增队列取出数据的次数
            take++;

            // 如果该节点的左子树不为空,添加到队列
            if (temp.left != null) {
                que.add(temp.left);
            }
            // 如果该节点的右子树不为空,添加到队列
            if (temp.right != null) {
                que.add(temp.right);
            }

            if (take == push) {
                // 添加一层的最右节点到结果列表中
                result.add(temp.val);
                // 初始化take和push次数
                take = 0;
                push = que.size();
            }
            // 递归操作思路 查找每层高度,高于之前出现过右节点的高度
            //https://www.youtube.com/watch?v=3Qjm1iX5dw8&ab_channel=FitCoder
            
            // 二叉树操作
            // https://blog.csdn.net/weixin_44259720/article/details/121494049
        }
        return result;
    }
}
