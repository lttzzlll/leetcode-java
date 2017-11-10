package RemoveNthNodeFromEndofList;

/**
 * Created by liutaotao on 2017/11/10.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int len = getLength(head);
        if  (n == len) {
            return head.next;
        }
        int pos = len - n, i = 0;
        ListNode cur = head;
        while (cur.next != null) {
            ++i;
            if (i == pos) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node =new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = null;
        Solution solution = new Solution();
        ListNode head = solution.removeNthFromEnd(node, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
