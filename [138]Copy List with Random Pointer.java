/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node tempHead = head;
        //创建储存node的map, key值是原链表, value是复制链表
        Map<Node, Node> map = new HashMap<>();

        //每次循环建立一个新节点, 储存源节点的val
        while (tempHead != null) {
            // curVla是复制后节点的表头
            Node curVal = new Node(tempHead.val);

            //将源节点表头和新节点表头存到map中
            map.put(tempHead,curVal);
            //移动节点
            tempHead = tempHead.next;
        }
        //重置tempHead到源节点表头位置, 作为后续map的Key
        tempHead = head;
        while(tempHead!=null){
            //目前复制链表只有value, next和random都是空
            //map.get(tempHead)是得到复制链表的头节点(map的value)
            //map.get(tempHead).next将 原来链表中head的next,保存到头节点的next中
            //例如 map.get(tempHead)是得到value为7,next和random为null的新节点
            //    map.get(tempHead.next)是得到value为13,next和random为null的新节点
            //将13节点保存到7的next中, 实现链表的连接, random同理
            map.get(tempHead).next = map.get(tempHead.next);
            map.get(tempHead).random = map.get(tempHead.random);

            //移动链表
            tempHead = tempHead.next;
        }

        //返回map中key为head的的value(新链表的头)
        //tempHead已经指向原链表的末端,这里要用head
        return map.get(head);

    }
}