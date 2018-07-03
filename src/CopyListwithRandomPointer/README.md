### [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/description/)

建立一个映射就完了.虽然是DeepCopy,但是没有涉及到循环引用的情况, 所以比较简单.

代码:

```Java
import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = null, cur = null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (node == null) {
                node = new RandomListNode(head.label);
                node.random = head.random;
                cur = node;
                map.put(head, node);
            } else {
                cur.next = new RandomListNode(head.label);
                cur.next.random = head.random;
                cur = cur.next;
                map.put(head, cur);
            }
            head = head.next;
        }
        cur = node;
        while (cur != null) {
            if (cur.random != null) {
                cur.random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return node;
    }
}
```

