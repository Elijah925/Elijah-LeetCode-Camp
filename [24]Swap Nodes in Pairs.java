/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //初始化, result从0开始,方便更改head
        ListNode result = new ListNode(0,head);
        //cur 起始在1节点, next不为空需要和secNode换位
        ListNode cur = head;
        ListNode preNode = result;

        while(cur != null && cur.next !=null){
            //secNode在cur的下一个, 需要和cur换位的节点
            ListNode secNode = cur.next;
            //第二组需要交换的前一个节点
            ListNode nextPreNode = cur.next.next;

            //第一个循环中
            //更改节点指针指向目标 2->1
            secNode.next = cur;
            //更改节点指针指向目标 1->3
            cur.next = nextPreNode;
            //更改节点指针指向目标 虚拟头节点指向2
            preNode.next = secNode;

            //更新节点指向1, 原因同result初始化
            //此时数据为2134,
            preNode = cur;
            //更新当前节点到第三位
            cur = nextPreNode;
        }

        //返回虚拟节点的下一位
        return result.next;
    }
}