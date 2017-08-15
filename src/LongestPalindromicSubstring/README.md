### 多种方式来求解这个问题
1. 朴素枚举
时间复杂度: O(n^3)   
> 枚举字符串的所有子串，判断子串是否为回文串，取其中最长的子串。   
```
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        n = len(s)
        res = 0
        start, end = 0, 0
        for i in range(n):
            for j in range(i + 1, n):
                cnt = j - i + 1
                if cnt > res and s[i: j] == s[j: i: -1]:
                    res = cnt
                    start, end = i, j 
        return s[start: end + 1]
```

2. 动态规划
时间复杂度：O(n^2)
动态规划的使用前提：1.最优子结构 2.重叠子问题   
> 子串枚举的过程中产生了大量的重复判断，用状态dp[i][j]记录子串s[i:j]是否为回文字符串。   
> 枚举子串时按照字串长度的顺序进行枚举，若s[i+1:j-1]是回文串并且s[i] == s[j]，那么s[i:j]也是回文串。
> 注意：空串也是回文串。如何表示一个空串：当i > j的时候说明 s[i: j]是一个空串。   
```
class Solution(object):
    def longestPalindrome(self, s):
        if s is None or len(s) < 2:
            return s

        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]

        for i in range(n):
            for j in range(n):
                dp[i][j] = True if i >= j else False
        
        maxLen = 0
        start, end = 0, 0

        # step size of each step
        for stepLen in range(2, n + 1):
            # start point
            for i in range(0, n - stepLen + 1):
                # end point
                j = i + stepLen - 1
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1]
                    if dp[i][j]:
                        if j - i + 1 > maxLen:
                            maxLen = j - i + 1
                            start, end  = i, j

        return s[start: end + 1]
```

3. 中心拓展   
时间复杂度：O(n^2)   
> 回文串都是中心对称的。因此可以从回文串的中心开始枚举，向两边拓展。
> 中心可以是字符，也可以是字符串之间的间隙，为了方便起见，将字符串的字符之间插入一个特殊的字符。   
```
class Solution(object):
    def longestPalindrome(self, s):
        if s is None or len(s) < 2:
            return s
        # 注意#必须在两侧都有     
        s = '#' + '#'.join(list(s)) + '#'

        n = len(s)
        maxLen = 0

        for i in range(1, n - 1):
            left = right = i
            while left - 1 >= 0 and right + 1 < n and s[left - 1] == s[right + 1]:
                left -= 1
                right += 1
            if right - left + 1 > maxLen:
                maxLen = right - left + 1
                start, end = left, right

        return s[start: end + 1].replace('#', '')
```

建小时间复杂度的关键就是如何减小计算量。如果有重复计算的部分，一定要把该部分拿掉才能减小时间复杂度。
