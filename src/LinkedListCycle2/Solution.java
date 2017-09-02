package LinkedListCycle2;

/**
 * Created by liutaotao on 2017/9/1.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) return null;
            if (fast == slow) break;
        }
        if (slow == fast) {
            fast = head;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = null;
        int[] arr = new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 222, 23, -21, 555};
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(arr[i]);
            node.next = head;
            head = node;
        }
        ListNode curr = head, temp = head;
        while (curr.next != null) curr = curr.next;
        for (int i = 0; i < 24; i++) {
            temp = temp.next;
        }
        System.out.println(curr.val);
        System.out.println(temp.val);
        curr.next = temp;
        Solution solution = new Solution();
        ListNode cur = solution.detectCycle(head);
        if (cur != null) {
            System.out.println(cur.val);
        } else {
            System.out.println("no cycle!");
        }
    }

}
