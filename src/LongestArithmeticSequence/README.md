### [1027. Longest Arithmetic Sequence](https://leetcode.com/problems/longest-arithmetic-sequence/)


1. 表格模式

```Python
class Solution:
    def longestArithSeqLength(self, A):
        memo = {}
        for i in range(0, len(A) - 1):
            for j in range(i + 1, len(A)):
                distance = A[j] - A[i]
                memo[(j, distance)] = memo.get((i, distance), 1) + 1

        return max(memo.values())
```


以 (当前节点, 当前节点的距离): 最优解 为一个基本的单位.
