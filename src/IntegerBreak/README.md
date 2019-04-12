### [343. Integer Break](https://leetcode.com/problems/integer-break/)


1. 备忘录模式[自顶向下]

```Python
class Solution:
    def integerBreak(self, n):
        if n == 2:
            return 1
        if n == 3:
            return 2
        self.memo = {}
        return self.f(n)
    
    def f(self, n):
        if n in self.memo:
            return self.memo[n]
        if n < 4:
            return n
        r = max(2 * self.f(n - 2), 3 * self.f(n - 3))
        self.memo[n] = r
        return r
```


2. 表格模式[自底向上]

```Python
class Solution:
    def integerBreak(self, n):
        if n == 2:
            return 1
        if n == 3:
            return 2
        dp = [0, 1, 2, 3] + [0] * (n - 3)

        for i in range(4, n + 1):
            dp[i] = max(dp[i - 2] * 2, dp[i - 3] * 3)
        return dp[n]
```

这道题最重要的就是要找出规律: 最大的数字有2或3相乘得出.
所以可以很容易得到状态转移方程: f(n) = max(f(n - 2) * 2, f(n - 3) * 3)
