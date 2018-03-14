package ClimbingStairs;

/**
 * Created by liutaotao on 2018/3/14.
 */
public class Solution {

    /**
     *                 4
     *            3       2
     *         1    2   1   1
     *            1   1
     *
     *
     *
     */
//    int[] dp = new int[1000];
//    public int climbStairs(int n) {
//        if (dp[n] != 0) return dp[n];
//        if (n == 1) return 1;
//        else if (n == 2) return 2;
//        else {
//            dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
//            return dp[n];
//        }
//    }

    private int fib(int n) {
        if (n  == 1) return 1;
        if (n == 2) return 2;
        int res = 0, a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public int climbStairs(int n) {
        return fib(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 11; i++) {
            System.out.println(i + "  " + solution.climbStairs(i));
        }
        System.out.println(solution.climbStairs(44));
    }
}
