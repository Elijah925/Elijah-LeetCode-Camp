/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建新链表, 在输入链表的头部节点插入一个新节点
        //防止边缘情况, 例如删除第一个节点, 例子1中 n=5 时
        //此时res 包含[0,1,2,3,4,5]
        ListNode res = new ListNode(0, head);

        //临时节点, 需要删除的节点后面的那一个节点
        ListNode left = res;

        //遍历到第N个数, 和while连起来理解
        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        //当head为空时, 运行了链表长度 - N次
        while (head != null) {
            head = head.next;
            //因为left初始化指向0,
            //此时left指向需要删除的节点的前一个
            left = left.next;
        }

        //跳过需要删除的节点, 以例子1为例
        //此时更改了节点3, 将节点3的next指向节点5,达到删除节点4的效果
        left.next = left.next.next;

        //left已经在循环中移动过了, 所以此时返回res链表的next(跳过0)
        return res.next;
    }
}