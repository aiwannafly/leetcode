package linkedpalindrome;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        // [1, 2, 2, 1]
        int len = len(head);
        if (len <= 1) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        if (len % 2 != 0) {
            head = head.next;
        }
        for (int i = 0; i < len / 2; i++) {
            Integer curr = stack.poll();
            if (curr != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private int len(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
