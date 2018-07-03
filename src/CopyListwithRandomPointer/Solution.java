package CopyListwithRandomPointer;

import java.util.HashMap;

/**
 * Created by liutaotao on 2018/7/3.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    public String toString() {
        return String.valueOf(label);
    }
}

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

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next.next.next;
        head.next.random = head.next.next.next;
        head.next.next.next.random = head;

        RandomListNode cur = head;
        while (cur != null) {
            System.out.println(cur + " | " + cur.random);
            cur = cur.next;
        }

        System.out.println("----------------------------");

        Solution solution = new Solution();
        RandomListNode ret = solution.copyRandomList(head);

        cur = ret;
        while (cur != null) {
            System.out.println(cur + " | " + cur.random);
            cur = cur.next;
        }
    }
}
