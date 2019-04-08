### [658. Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)


这道题其实可以用简单的排序就可以完成, 但是时间花费很大, 明显不是最优解.
因为中间用到了排序, 所以时间复杂度至少是O(n*log(n)).并且可以认为排序的
时间复杂度可以贴近O(n^2).

```Python
from bisect import bisect_left
from collections import defaultdict
class Solution:
    def findClosestElements(self, arr, k, x):
        memo = defaultdict(list)
        for num in arr:
            items = memo[abs(num - x)]
            pos = bisect_left(items, num)
            items.insert(pos, num)
        res = []
        memo_list = sorted(memo.items(), key=lambda x: x[0])
        for (distance, items) in memo_list:
            res.extend(items)
            if len(res) >= k:
                break
        return sorted(res[:k])
```

问题: 还有更优的解决方法吗?有没有一种时间复杂度为O(n)的算法呢?是否存在呢?


这里有一种O(log(n))时间复杂度的算法.其基本思路就是二分查找, 只不过在这里加上了区间.

```Python
class Solution:
    def findClosestElements(self, A, k, x):
        left, right = 0, len(A) - k
        while left < right:
            mid = (left + right) // 2
            if x - A[mid] > A[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return A[left:left + k]
```
