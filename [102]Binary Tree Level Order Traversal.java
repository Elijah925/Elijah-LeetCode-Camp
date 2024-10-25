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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //初始化返回列表
        List<List<Integer>> result = new ArrayList<>();
        //判断边界
        if (root == null) {
            return result;
        }
        //队列特性, 先进先出, 用以保存节点
        Queue<TreeNode> que = new LinkedList<>();
        //将根节点默认添加到队列中
        que.add(root);

        //创建保存每层数据的列表
        List<Integer> sublist = new ArrayList<>();

        //判断放入和取出队列的次数,
        int take = 0;
        int push = 1;

        //队列不为空时往后循环
        while (!que.isEmpty()) {
            //poll取出并删除第一个元素
            TreeNode temp = que.poll();
            //自增队列取出数据的次数
            take++;
            //添加该节点数据到的列表中
            sublist.add(temp.val);

            //如果该节点的左子树不为空,添加到队列
            if (temp.left != null) {
                que.add(temp.left);
            }
            //如果该节点的右子树不为空,添加到队列
            if (temp.right != null) {
                que.add(temp.right);
            }

            //如果拿出和放入次数相同,代表这一层已经走完了
            //例如走完第一遍的时候, 3已经保存到列表中, 此时que放入了9和20, push为2, take为0
            //取出9时,push为2, take为1 ,
            //取出20时, push为2, take为2, que放入15和7, que大小为2
            //下一次循环就开始遍历15和7
            if (take == push) {
                //添加一层的列表到结果列表中
                result.add(new ArrayList<>(sublist));
                //清空每层的列表
                sublist.clear();
                //初始化take和push次数
                take = 0;
                push = que.size();
            }

            //参考
            //https://www.youtube.com/watch?v=6ZnyEApgFYg&ab_channel=NeetCode

            //二叉树操作
            //https://blog.csdn.net/weixin_44259720/article/details/121494049
        }
        return result;
    }
}