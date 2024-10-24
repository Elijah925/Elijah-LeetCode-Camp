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
    public ListNode sortList(ListNode head) {
        //暴力破解, 时间复杂度O(n^2),test28 会超时
        // ListNode result = new ListNode(0,head);
        // ListNode cur = head;
        // int value = 0;
        // while(cur != null ){
        //     ListNode nextCompareNode = cur.next;
        //     //内循环将每一个节点,与后面的所有节点比大小, 大的val后移, 例如 例子2中循环结果为
        //     //[-1,3,4,0,5]
        //     //[-1,0,4,3,5] 3比4小,所以跳过了4,3和0换
        //     //[-1,0,3,4,5] 最终结果
        //     while(nextCompareNode != null){
        //         if(cur.val > nextCompareNode.val){
        //             value = cur.val;
        //             cur.val = nextCompareNode.val;
        //             nextCompareNode.val = value;
        //         }
        //         nextCompareNode = nextCompareNode.next;
        //     }
        //     cur = cur.next;
        // }

        ListNode result = new ListNode(0,head);
        //用列表是因为动态空间, 并且可能有重复
        List<Integer> valList = new ArrayList<>();
        ListNode cur = head;
        //遍历链表,将所有节点中的值储存到列表中
        while(cur!=null){
            valList.add(cur.val);
            cur = cur.next;
        }

        //链表排序
        Collections.sort(valList);
        //重置当前节点
        cur = head;

        //按排序后的顺序对每个节点重新赋值
        while(cur!=null){
            cur.val = valList.get(0);
            valList.remove(0);
            cur = cur.next;
        }

        return result.next;
    }
}