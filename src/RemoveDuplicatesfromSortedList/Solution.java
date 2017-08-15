package RemoveDuplicatesfromSortedList;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, cur = head.next;
        while (cur != null) {
            while (cur != null && cur.val == prev.val) {
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }
        return head;
    }
}
