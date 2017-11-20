package DivideTwoIntegers;

/**
 * Created by liutaotao on 2017/11/18.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        // determine sign +1 or -1
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        // make dividend positive
        long ldividend = Math.abs((long) dividend);
        // make divisor positive
        long ldivisor = Math.abs((long) divisor);
        // if divisor == 0, return MAX_VALUE
        if (ldivisor == 0) return Integer.MAX_VALUE;
        // if dividend == 0 || dividend < divisor, return 0
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
        // get the answer
        long lans = ldivide(ldividend, ldivisor);
        int ans;
        // if the answer > MAX_VALUE
        if (lans > Integer.MAX_VALUE) {
            // return MAX_VALUE if sign == 1 or MIN_VALUE if sign == -1
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            // return sign * lans
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // dividend < divisor, return 0
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        int multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {

    }
}
