### [1025. Divisor Game](https://leetcode.com/problems/divisor-game/)

从结果来看:
```
2   Win
3   Lose
4   Win
5   Lose
6   Win
7   Lose
8   Win
9   Lose
10  Win
```

1. 归纳总结: 奇数的时候Alice输, 偶数的时候Alice赢.

```Python
class Solution:
    def divisorGame(self, N):
        return N & 1 == 0
```

2. 采用动态规划的方式, 从已知解推出未知解. [表格模式]

```Python
class Solution:
    def divisorGame(self, N):
        if N == 1:
            return False
        if N == 2:
            return True
        if N == 3:
            return False
   
        dp = [False] * (N + 1)
        dp[2] = True
        dp[3] = False 
        for i in range(4, N + 1):
            for j in range(1, i // 2 + 1):
                if dp[i]:
                    break
                if i % j == 0:
                    dp[i] = not dp[i - j]
        return dp[N]
```

状态转移方程:
```
dp[n] = !dp[n - i] for i in range(1, n // 2 + 1)


dp[1] = False
dp[2] = True
dp[3] = False
```

从已知解可以推出未知解.


3. 备忘录模式

```Python
class Solution:
    def divisorGame(self, N):
        if N == 1:
            return False
        if N == 2:
            return True
        if N == 3:
            return False
        for i in range(1, N // 2 + 1):
            if N % i == 0:
                r = not self.divisorGame(N - i)
                if r:
                    return r
        return False
```

加上缓存

```Python
class Solution:
    def divisorGame(self, N):
        self.memo = {}
        return self.f(N)

    def f(self, N):
        if N in self.memo:
            return self.memo[N]

        if N == 1:
            return False
        if N == 2:
            return True
        if N == 3:
            return False

        r = False
        for i in range(1, N // 2 + 1):
            if N % i == 0:
                if (N - i) in self.memo:
                    r = not self.memo[N - i]
                else:
                    r = not self.divisorGame(N - i)
                if r:
                    break
        self.memo[N] = r
        return r
```

关键要找到题目中隐含的条件, 并加以利用.
