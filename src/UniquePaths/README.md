### [Unique Paths](https://leetcode.com/problems/unique-paths)


动态规划简单题。最重要的一点就是弄清楚状态转移方程。本题中，状态转移方程为:
```
dp(i, j) = dp(i - 1, j) + dp(i, j - 1)
dp(i, 1) = dp(1, j) = 1
```

边界值可以通过状态转移方程反推过来。

代码如下:
```Java
public class Solution {

    public int uniquePaths(int m, int n)  {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
```
