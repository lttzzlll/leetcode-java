### [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/discuss/)
1. Naive Method
```
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode node : lists) { // time cost: n^2
            res = merge(res, node);
        }
        return res;
    }
```
> Time Cost: O(n^2)
```
0 1
  1 2
    3 3
      6 4
       10 5
         15 6
           21 7
             28 8
               36 9
                 45 10
                    55
1 + 3 + 6 + 10 + 15 + 21 + 28 + 36 + 45 + 55 = 220

```


2. Force Method
```
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
```

> Time Cost: O(n^2)
```
0 1
  1 2
    3 3
      6 4
       10 5
         15 6
           21 7
             28 8
               36 9
                 45 10
                    55
1 + 3 + 6 + 10 + 15 + 21 + 28 + 36 + 45 + 55 = 220

```

3. Priority Queue
```
      public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return 1;
                else if (o1.val == o2.val) return 0;
                else return -1;
            }
        }
        );

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode head = null;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = head;
            head = node;
        }

        return head;
    }
```

> Time Cost: n*log(n)
```
插入的时候调正元素的位置log(n), 一共有n个元素,时间复杂度 n * log(n)
```

4. Divide And Conquer, Recursive
```
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

```

> Time Cost: n*log(n), 每次划分元素用时log(n),每次合并元素用时n,时间复杂度 n * log(n)