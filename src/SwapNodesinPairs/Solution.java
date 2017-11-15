package SwapNodesinPairs;

/**
 * Created by liutaotao on 2017/11/15.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode first = head, second = head.next, succ = swapPairs(second.next);
        first.next = succ;
        second.next = first;
        return second;
    }
    // 1->2->3-4->||
    public static void main(String[] args) {
        ListNode head = null;
        int n = 10;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(n - i);
            node.next = head;
            head = node;
        }

        Solution solution = new Solution();
        ListNode cur = solution.swapPairs(head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
