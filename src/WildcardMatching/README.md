### [44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)


1. 备忘录模式 [自顶向下]

```Python
class Solution:
    def isMatch(self, s, p):
        self.memo = {}
        return self.f(s, 0, p, 0)

    def f(self, s, i, p, j):
        if (i, j) in self.memo:
            return self.memo[(i, j)]
        # specail case
        # s == "", p == "*"
        if i == len(s) and (j == len(p) or p[j:] == (len(p) - j) * "*"):
            return True
        if i >= len(s) or j >= len(p):
            return False
        if s[i] == p[j] or p[j] == '?':
            self.memo[(i, j)] = self.f(s, i + 1, p, j + 1)
            return self.memo[(i, j)]
        if p[j] == '*':
            self.memo[(i, j)] = self.f(s, i + 1, p, j + 1) or self.f(s, i + 1, p, j) or self.f(s, i, p, j + 1)
            return self.memo[(i, j)]
        return False

```


2. 表格模式 [自底向上]

```Python
class Solution:
    def isMatch(self, s, p):
        s_len, p_len = len(s), len(p)
        dp = [[False] * (s_len + 1) for _ in range(p_len + 1)]
        dp[0][0] = True
        for i in range(1, p_len + 1):
            if p[i - 1] == "*":
                dp[i][0] = dp[i - 1][0] or dp[i][0]

        for i in range(1, p_len + 1):
            for j in range(1, s_len + 1):
                if p[i - 1] == "*":
                    dp[i][j] = dp[i - 1][j] or dp[i][j - 1] or dp[i][j]
                elif p[i - 1] == "?" or p[i - 1] == s[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
        return dp[p_len][s_len]

```

这类问题的解法: 采用备忘录模式的时候, i, j 的移动是同时进行的. 但如果采用表格模式,
会发现无法实现i, j 同时移动. 因为

```Python
for i in range():
    for j in range():
        dp[i][j] = ...
```

这里的i, j 不能算作是同时移动的, 所以在初始化dp的时候, 需要提前设置dp数组的状态,使之可以
实现"同时移动"的效果, 这也就是Python代码中第6行初始化dp数组的目的.

另外, s, p的顺序其实并不重要, 下面就是把s, p反过来放置的代码, 依然正确.


```Python
class Solution:
    def isMatch(self, s, p):
        s_len, p_len = len(s), len(p)
        dp = [[False] * (p_len + 1) for _ in range(s_len + 1)]
        dp[0][0] = True
        for i in range(1, p_len + 1):
            if p[i - 1] == "*":
                dp[0][i] = dp[0][i - 1] or dp[0][i]

        for i in range(1, s_len + 1):
            for j in range(1, p_len + 1):
                if p[j - 1] == "*":
                    dp[i][j] = dp[i - 1][j] or dp[i][j - 1] or dp[i][j]
                elif p[j - 1] == "?" or p[j - 1] == s[i - 1]:
                    dp[i][j] = dp[i - 1][j - 1]

        return dp[s_len][p_len]

```

通过代码理解其所表达的意思. 