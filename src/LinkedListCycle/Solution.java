package LinkedListCycle;

/**
 * Created by liutaotao on 2017/11/6.
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->8->9->10->11
        ListNode head = null;
        int n = 11;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(n - i);
            node.next = head;
            head = node;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

//        cur = head;
//        while (cur.next != null) {
//            cur = cur.next;
//        }
//        cur.next = head;

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }
}
