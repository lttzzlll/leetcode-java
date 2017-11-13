package MergekSortedLists;

/**
 * Created by liutaotao on 2017/11/11.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

//    /***
//     * merge to sorted linked list using recursive
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    private ListNode merge(ListNode a, ListNode b) {
//        if (a == null) {
//            return b;
//        }
//        if (b == null) {
//            return a;
//        }
//        if (a.val <= b.val) {
//            a.next = merge(a.next, b);
//            return a;
//        } else {
//            b.next = merge(a, b.next);
//            return b;
//        }
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode res = null;
//        for (ListNode node : lists) { // time cost: n^2
//            res = merge(res, node);
//        }
//        return res;
//    }

//    private int getLength(ListNode head) {
//        int count = 0;
//        while (head != null) {
//            ++count;
//            head = head.next;
//        }
//        return count;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, cur = null;
        int minNodeIdx = -1;
        int minVal = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;

        while (true) {
            minNodeIdx = -1;
            minVal = Integer.MAX_VALUE;
            for (int j = 0; j < lists.length; j++) {
                if (lists[j] != null && lists[j].val < minVal) {
                    minVal = lists[j].val;
                    minNodeIdx = j;
                }
            }
            if (minNodeIdx == -1) {
                break;
            }
            if (head == null) {
                head = lists[minNodeIdx];
            }
            if (cur == null) {
                cur = lists[minNodeIdx];
            } else {
                cur.next = lists[minNodeIdx];
                cur = cur.next;
            }
            lists[minNodeIdx] = lists[minNodeIdx].next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = null;
        ListNode b = new ListNode(2);
        b.next = null;

        ListNode[] lists = new ListNode[]{a, b};
        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
