### [983. Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)

这是一道很基础的动态规划的题。其中可以优化的地方在于时间范围的指定。一开始我们指定1年(365)的时间。后来发现只需要指定(1 + 7 + 30 = 38)天的时间范围即可，因为上下两次时间间隔最长不会超过该间隔。

1. 朴素版本

```Python
class Solution:
    def mincostTickets(self, days, costs):
        days_set = set(days)
        dp = {0: 0}
        for day in range(1, 366):
            if day not in days_set:
                dp[day] = dp[day - 1]
            else:
                dp[day] = min(dp[day - 1] + costs[0], dp[max(0, day - 7)] + costs[1], dp[max(0, day - 30)] + costs[2])
        return dp[365]
```

2. 改进版本

```Python
class Solution:
    def mincostTickets(self, days, costs):
        days_set = set(days)
        dp = [0 for _ in range(30)]
        for day in range(days[0], days[-1] + 1):
            if day not in days_set:
                dp[day % 30] = dp[(day - 1) % 30]
            else:
                dp[day % 30] = min(dp[(day - 1) % 30] + costs[0], dp[max(0, (day - 7) % 30)] + costs[1], dp[max(0, (day - 30) % 30)] + costs[2])

        return dp[days[-1] % 30]
```
