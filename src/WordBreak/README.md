### [139. Word Break](https://leetcode.com/problems/word-break/)


1. 备忘录模式[自顶向下]

```Python
class Solution:

    def wordBreak(self, s, wordDict):
        self.memo = {word: True for word in wordDict}
        return self.f(s, wordDict)

    def f(self, s, wordDict):
        memo = self.memo
        if s in memo:
            return memo[s]
        if s == "":
            return True
        for word in wordDict:
            if s[:len(word)] == word:
                r = self.f(s[len(word):], wordDict)
                if r:
                    memo[s] = r
        if s not in memo:
            memo[s] = False
        return memo[s]
```

2. 表格模式[自底向上]

```Python
class Solution:
    def wordBreak(self, s, wordDict):
        dp = [True] + [False] * len(s)
        for i in range(len(s)):
            if dp[i]:
                for word in wordDict:
                    if i + len(word) <= len(s) and s[i: i + len(word)] == word:
                        dp[i + len(word)] = True
        return dp[-1]
```

自底向上的模式非常简单.
