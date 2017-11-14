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

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = null, cur = null;
//        int minNodeIdx = -1;
//        int minVal = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
//
//        while (true) {
//            minNodeIdx = -1;
//            minVal = Integer.MAX_VALUE;
//            for (int j = 0; j < lists.length; j++) {
//                if (lists[j] != null && lists[j].val < minVal) {
//                    minVal = lists[j].val;
//                    minNodeIdx = j;
//                }
//            }
//            if (minNodeIdx == -1) {
//                break;
//            }
//            if (head == null) {
//                head = lists[minNodeIdx];
//            }
//            if (cur == null) {
//                cur = lists[minNodeIdx];
//            } else {
//                cur.next = lists[minNodeIdx];
//                cur = cur.next;
//            }
//            lists[minNodeIdx] = lists[minNodeIdx].next;
//        }
//        return head;
//    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
//                lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) return 1;
//                else if (o1.val == o2.val) return 0;
//                else return -1;
//            }
//        }
//        );
//
//        for (ListNode node : lists) {
//            while (node != null) {
//                queue.add(node);
//                node = node.next;
//            }
//        }
//
//        ListNode head = null;
//
//        while (!queue.isEmpty()) {
//            ListNode node = queue.poll();
//            node.next = head;
//            head = node;
//        }
//
//        return head;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int low, int high) {
        if (low > high) return null;
        else if (low < high) {
            int mid = (low + high) / 2;
            ListNode left = partition(lists, low, mid);
            ListNode right = partition(lists, mid + 1, high);
            return merge(left, right);
        } else return lists[low];
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val <= b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    /**
     * 0
     * 1 1
     *   2 3
     *     3 6
     *       4 10
     *          5 15
     *             6 21
     *                7 28
     *                   8 36
     *                      9 45
     *                        10 55
     */

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = null;
        ListNode b = new ListNode(2);
        b.next = null;

        /**
         * 1->4->7->10
         * 2->5->8->11
         * 3->6->9->12
         */
        ListNode[] lists = new ListNode[]{a, b};
        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
