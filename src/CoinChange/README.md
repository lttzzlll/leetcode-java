### [322. Coin Change](https://leetcode.com/problems/coin-change/)


这道题的特点在于既要判断有无解，又要找出最优解。所以用动态对规划一步搞定。属于动态规划中的基础题。

1. 备忘录模式[自顶向下]

```Python
class Solution:
    def __init__(self):
        self.memo = {}
        self.INVALID = 999999

    def coinChange(self, coins, amount):
        r = self.change(coins, amount)
        return r if r < self.INVALID else -1

    def change(self, coins, amount):
        if amount in self.memo:
            return self.memo[amount]
        if amount < 0:
            return self.INVALID
        if amount == 0:
            return 0
        res = []
        for coin in coins:
            r = self.change(coins, amount - coin)
            res.append(r)
        t = min(res) + 1
        self.memo[amount] = t
        return t
```

2. 表格模式[自底向上]

```Python
class Solution:
    def coinChange(self, coins, amount):
        """in this case, amount + 1 is truely invalid number"""
        dp = [0] + [amount + 1] * amount
        for i in range(1, amount + 1):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i-coin] + 1)
        return dp[amount] if dp[amount] != amount + 1 else -1
```

这道题的思路还是非常简单的。