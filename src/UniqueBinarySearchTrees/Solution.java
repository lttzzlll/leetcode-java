package UniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[Integer.max(n, 2) + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 1; i <= 10; i++) {
            int r = s.numTrees(i);
            System.out.println(r);
        }
    }
}