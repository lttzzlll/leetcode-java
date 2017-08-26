package Pow;

/**
 * Created by liutaotao on 2017/8/26.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1.0 / myPow(x, -n);
            }
        }
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) > 0) { // odd
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        double a = 34.00515;
        int n = -3;
        Solution solution = new Solution();
        System.out.println(String.format("%5.6f", solution.myPow(a, n)));
    }
}
