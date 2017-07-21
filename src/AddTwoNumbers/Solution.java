package AddTwoNumbers;

import java.util.Arrays;

/**
 * Created by 10609 on 2017/7/20.
 */

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lst = null, tmp = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 == null) {
                val = l2.val;
            } else if (l2 == null) {
                val = l1.val;
            } else {
                val = l1.val + l2.val;
            }
            ListNode node = new ListNode((val + carry) % 10);
            carry = (val + carry) / 10;
            if (lst == null) {
                lst = node;
            }
            if (tmp == null) {
                tmp = node;
            } else {
                tmp.next = node;
                tmp = tmp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tmp.next = new ListNode(carry);
            tmp.next.next = null;
        }
        return lst;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = null;
        ListNode l2 = new ListNode(1);
        l2.next = null;
        Solution solution = new Solution();
        ListNode lst = solution.addTwoNumbers(l1, l2);
        while (lst != null) {
            System.out.print(String.format("%4d", lst.val));
            lst = lst.next;
        }
        System.out.println();
    }
}