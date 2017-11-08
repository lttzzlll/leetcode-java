package IntersectionofTwoLinkedLists;

/**
 * Created by liutaotao on 2017/11/7.
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
    private int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private ListNode checkSameLength(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        } else {
            int lenA = getLength(headA);
            int lenB = getLength(headB);
            if (lenA > lenB) {
                while (lenA > lenB) {
                    if (headA == headB) {
                        return headB;
                    }
                    headA = headA.next;
                    lenA--;
                }
            } else if (lenB > lenA) {
                while (lenB > lenA) {
                    if (headB == headA) {
                        return headA;
                    }
                    headB = headB.next;
                    lenB--;
                }
            }
            return checkSameLength(headA, headB);
        }
    }

    public static void main(String[] args) {
//        ListNode headA = new ListNode(1);
//        headA.next = new ListNode(2);
//        ListNode headB = new ListNode(11);
//        headB.next = new ListNode(12);
//        headB.next.next = new ListNode(13);
//        ListNode common = new ListNode(20);
//        common.next = new ListNode(21);
//        common.next.next = new ListNode(22);
//        common.next.next.next = null;
//
//        headA.next.next = common;
//        headB.next.next.next = common;

        int[] arr = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        int[] arr1 = new int[]{1, 3, 5, 7, 9};
        ListNode headA = null;
        ListNode headB = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[arr.length - 1 - i]);
            node.next = headB;
            headB = node;
        }

        for (int i = 0; i <arr1.length; i++) {
            ListNode node = new ListNode(arr1[arr1.length - 1 - i]);
            node.next = headA;
            headA = node;
        }
        headA.next.next.next.next.next = headB;

        Solution solution = new Solution();

        ListNode res = solution.getIntersectionNode(headA, headB);
        if (res != null) {
            System.out.println(res.val);
        }
    }
}
