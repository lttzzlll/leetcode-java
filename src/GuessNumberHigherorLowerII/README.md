### [375. Guess Number Higher or Lower II
](https://leetcode.com/problems/guess-number-higher-or-lower-ii/)


1. 备忘录版本[自顶向下] 

```Python
class Solution:
    def __init__(self):
        self.memo = {}

    def getMoneyAmount(self, n):
        return self.guess(1, n)

    def guess(self, start, end):
        pos = (start, end)
        memo = self.memo
        guess = self.guess
        if pos in memo:
            return memo[pos]
        if start >= end:
            return 0
        minval = 999999
        pivot = (start + end) // 2
        for i in range(pivot, end + 1):
            r = max(guess(start, i - 1), guess(i + 1, end)) + i
            if r < minval:
                minval = r
        memo[pos] = minval
        return minval
```

2. 表格模式[自底向上]

```Python
class Solution:
    def getMoneyAmount(self, n):
        # 全部初始化为0
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        # start, end 的目的很清楚,就是要确定问题的范围
        # end 是从1开始,一点一点增大的,象征自问题一点点增大到愿问题 [1, k] -> [1, n]
        # start 的起始位置为end - 1, 一直扩展到1, 象征着问题从[k, n] -> [1, n]
        # start 和 end 之所以如此设置, 就是为了使得问题可以被扩展,子问题到原问题的
        # 每一步都是"连续的".
        # 这里 "连续"的意思是保证下一步问题的求解建立为当前问题已经解决的基础上.
        # 从当前问题递进到下一个问题的"空间"必须是连续的,当前问题必须是已经解决的.
        # end [1, n]
        for end in range(1, n + 1):
            # start [1, end - 1]
            for start in range(end - 1, 0, -1):
                # dp[start][end] = ?
                dp[start][end] = 999999
                for pivot in range(start, end):
                    r = max(dp[start][pivot - 1], dp[pivot + 1][end]) + pivot
                    if r < dp[start][end]:
                        dp[start][end] = r
                 
        return dp[1][n]
```

表格模式首先要写出状态转移[递进]方程,这里的状态转移方程思考一下便很容易得出:
```
dp[start][end] = min{dp[start][i - 1] + dp[i + 1][end] + i} for i in [start, end]
```

但是得到了状态转移方程不代表可以写出代码,可以写对代码,因为代码是有很多细节在里面,必须要考虑清楚才可以.
关于代码的细节,只有在写的时候才能发现.
