package AddTwoNumbersII;

import java.util.List;
import java.util.Stack;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (ListNode cur = l1; cur != null; cur = cur.next) {
            stack1.push(cur.val);
        }
        for (ListNode cur = l2; cur != null; cur = cur.next) {
            stack2.push(cur.val);
        }

        int len = Math.max(stack1.size(), stack2.size());
        int carry = 0;
        ListNode head = null;
        boolean first = true;
        while (len > 0) {
            int val1 = 0, val2 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }
            int res = val1 + val2;
            int val = res + carry;

            if (first) {
                ListNode node = new ListNode(val % 10);
                node.next = head;
                head = node;
                first = false;
            } else  {
                ListNode node = new ListNode(val % 10);
                node.next = head;
                head = node;
            }

            carry = val / 10;

            len--;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }
}
