package UniquePaths;

public class Solution {
    /**
     * 分阶段求解最优解问题
     * 1. 最有子结构
     * 2. 重迭子问题
     * 3. 无后效性
     * 
     * f(i, j) = max(f(i - 1, j), f(i, j - 1)) - f(i - 1, j - 1) + 1
     * f(1, 1) = 1
     * f(1, 2) = 1
     * f(2, 1) = 1
     * f(2, 2) = 2
     * 1 1 1 1
     * 1 2 3 4
     * 1 3 5 7
     * 
     */
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 7, n = 3;
        int r = solution.uniquePaths(m, n);
        System.out.println(r);
    }
}