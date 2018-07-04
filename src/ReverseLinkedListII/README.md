### [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/description/)

SB写的巨长代码

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode node = null, cur = head, tmp;
        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = node;
            node = tmp;
        }
        return node;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;

        int i;
        ListNode cur = head, start = null, end = null, left, right;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (m == 1 && n == length) return reverse(head);
        else if (m == 1) {
            start = head;
            cur = head;
            i = 1;
            while (cur != null) {
                if (i == n) {
                    end = cur;
                    break;
                }
                cur = cur.next;
                i++;
            }
            left = head;
            right = end.next;
            end.next = null;
            head = reverse(head);
            left.next = right;
        } else if (n == length) {
            cur = head;
            i = 1;
            while (cur != null) {
                if (i + 1 == m) {
                    start = cur;
                    break;
                }
                cur = cur.next;
                i++;
            }
            left = start.next;
            start.next = null;
            start.next = reverse(left);
        } else {
            cur = head;
            i = 1;
            while (cur != null) {
                if (i + 1 == m) {
                    start = cur;
                    break;
                }
                cur = cur.next;
                i++;
            }
            while (cur != null) {
                if (i == n) {
                    end = cur;
                    break;
                }
                cur = cur.next;
                i++;
            }
            left = start.next;
            right = end.next;
            start.next = null;
            end.next = null;
            start.next = reverse(left);
            left.next = right;
            return head;
        }
        return head;
    }
}
```