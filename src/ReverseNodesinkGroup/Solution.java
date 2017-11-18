package ReverseNodesinkGroup;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            count++;
            cur = cur.next;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 10;
        ListNode head = null;
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
        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}