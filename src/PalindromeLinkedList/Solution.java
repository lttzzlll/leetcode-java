package PalindromeLinkedList;

/**
 * Created by 10609 on 2017/7/20.
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    private ListNode reverse(ListNode head) {
        ListNode cur = head, res = null;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = res;
            res = temp;
        }
        return res;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        if (head == null || head.next == null) {
            return true;
        }
        fast = slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        fast = head;
        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = null;
        Solution solution = new Solution();
        boolean res = solution.isPalindrome(head);
        System.out.println(res);
//        ListNode tt = solution.reverse(head);
//        while (tt != null) {
//            System.out.println(tt.val);
//            tt = tt.next;
//        }
    }
}
