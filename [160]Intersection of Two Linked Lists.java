/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 核心点是链表长度计算, A+B = B+A
        // 其次, 从交点开始，两个列表应该相同。
        // 所以,当将两个链表相加后,如果有交点,
        // 两个相加后的链表最后几位(交点之后)一定相同
        ListNode b = headB;
        ListNode a = headA;

        // 边界判断
        if (headA == null && headB == null) {
            return null;
        }

        // 循环a+b次, 达到a+b次之后 a和b都为null跳出循环
        while (a != b) {
            // 如果a不为空, 链表后移
            if (a != null) {
                a = a.next;
            }
            // 如果a为空(走到头了), 添加链表b到a中
            else {
                a = headB;
            }

            // 同上
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }

            // if(a!=null){
            // System.out.println("a=" + a.val);

            // }
            // if( b!=null){
            // System.out.println("b=" + b.val);
            // }

        }

        //跳出循环后a和b都是空,代表无交点
        return a;
    }
}