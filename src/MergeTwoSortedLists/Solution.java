package MergeTwoSortedLists;

/**
 * Created by liutaotao on 2017/8/28.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//
//        Stack<ListNode> stack = new Stack<>();
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                stack.push(l1);
//                l1 = l1.next;
//            } else {
//                stack.push(l2);
//                l2 = l2.next;
//            }
//        }
//        if (l1 == null) {
//            while (l2 != null) {
//                stack.push(l2);
//                l2 = l2.next;
//            }
//        } else if (l2 == null) {
//            while (l1 != null) {
//                stack.push(l1);
//                l1 = l1.next;
//            }
//        }
//        ListNode head = null;
//        while (!stack.isEmpty()) {
//            ListNode temp = stack.pop();
//            temp.next = head;
//            head = temp;
//        }
//        return head;
//    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            ListNode next = mergeTwoLists(l1.next, l2);
            l1.next = next;
            return l1;
        } else {
            ListNode next = mergeTwoLists(l1, l2.next);
            l2.next = next;
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
