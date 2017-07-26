package ReverseLinkedList;

/**
 * Created by 10609 on 2017/7/26.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next, first = head, last = head;
        while (cur != null) {
            head = cur;
            cur = cur.next;
            last.next = head.next;
            head.next = first;
            first = head;
        }
        return head;
    }
}
