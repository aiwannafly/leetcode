import linkedpalindrome.ListNode;
import linkedpalindrome.Solution;

public class Main {
    public static void main(String[] args) {
        var solution = new Solution();
        ListNode tail = new ListNode(2);
        ListNode head = new ListNode(2, tail);
        System.out.println(solution.isPalindrome(head));
    }
}
