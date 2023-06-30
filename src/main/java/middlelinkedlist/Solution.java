package middlelinkedlist;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode singleNode = head;
        ListNode doubleNode = head;
        while (true) {
            doubleNode = doubleNode.next;
            if (doubleNode == null) {
                return singleNode;
            }
            singleNode = singleNode.next;
            doubleNode = doubleNode.next;
            if (doubleNode == null) {
                return singleNode;
            }
        }
    }
}
