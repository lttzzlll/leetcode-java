### [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)

在 [62. Unique Paths](https://leetcode.com/problems/unique-paths/)的基础上略加变形,其实就是加了一个限制条件。其他什么都没变。

需要注意的地方有两处:
1. 初始化的地方,需要根据限制条件初始化表
2. 状态转移方程的地方,需要首先判断当前状态能否连通,若不联通,则dp[i][j] = 0; 若联通, 则dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

代码:
```Java
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)  {
                dp[i][0] = 0;
            } else if (i == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else if (j == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
```
