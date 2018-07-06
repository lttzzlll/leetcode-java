### [Partition List](https://leetcode.com/problems/partition-list/description/)

水了一题

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

}
```
