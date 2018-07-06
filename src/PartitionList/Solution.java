package PartitionList;

import java.util.Stack;

/**
 * Created by liutaotao on 2018/7/6.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null && cur.val < x) {
            stack.push(cur);
            cur = cur.next;
        }
        if (!stack.isEmpty()) {
            stack.peek().next = null;
        }
        ListNode start = cur;
        // cur is null
        if (cur == null) {
            ListNode end = start;
            while (!stack.isEmpty()) {
                ListNode node = stack.pop();
                node.next = end;
                end = node;
            }
            return end;
        }
        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = null;
                stack.push(tmp);
            } else {
                cur = cur.next;
            }
        }
        ListNode end = start;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = end;
            end = node;
        }
        return end;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        Solution solution = new Solution();
        ListNode node = solution.partition(head, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
