package RotateList;


/**
 * Created by 10609 on 2017/7/25.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int cnt = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cnt++;
            cur = cur.next;
        }
        if (k > cnt) {
            k %= cnt;
        }
        int num = k > 0 ? cnt - k: 0;
        ListNode first = head;
        while (num > 1) {
            head = head.next;
            num--;
        }
        if (num > 0) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            cur.next = first;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = node1;

        Solution solution = new Solution();
        ListNode res = solution.rotateRight(head, 10);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
