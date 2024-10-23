/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //set方法去重
        HashSet set = new HashSet();
        //节点不为空, 并且value没重复的时候 移动节点
        while (head != null && set.add(head)) {
            System.out.println(head.val);
            head = head.next;
        }
        //中间跳出代表set中已经有相同节点了,此时head为循环入口,直接返回就好
        //走完while, head为空时无循环节点,

        return head;
    }
}

//双指针方法,更快
// public ListNode detectCycle(ListNode head) {
//         // Initialize pointers at head of linkedlist...
//         ListNode p1 = head, p2 = head;
//         // Run a loop until p2 and p2.next is equal to null...
//         while (p2 != null && p2.next != null) {
//             p1 = p1.next;       // moving p1 by 1
//             p2 = p2.next.next;  // moving p2 by 2
//             // found the cycle...
//             if (p1 == p2)  break;
//         }
//         // In case there is no cycle or no meeting point...
//         if (p2 == null || p2.next == null) return null;
//         // run loop until again head & p1 don't collab...
//         while (head != p1) {
//             head = head.next;   // moving head by 1...
//             p1 = p1.next;   // moving p1 by 1 as well...
//         }
//         return head;       // Or return p1, they both will return the tail where cycle starts...
//     }