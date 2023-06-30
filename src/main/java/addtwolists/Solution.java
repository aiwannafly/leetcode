package addtwolists;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int rest = 0;
        while (true) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += rest;
            if (sum >= 10) {
                rest = 1;
                sum -= 10;
            } else {
                rest = 0;
            }
            tail.val = sum;
            if (l1 == null && l2 == null) {
                break;
            }
            ListNode newTail = new ListNode();
            tail.next = newTail;
            tail = newTail;
        }
        if (rest == 1) {
            tail.next = new ListNode(1);
        }
        return head;
    }
}
