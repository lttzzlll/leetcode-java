package Sqrt;

/**
 * Created by liutaotao on 2017/8/25.
 */
public class Solution {
//    public int mySqrt(int x) {
//        return (int) Math.sqrt(x);
//    }

//    public int mySqrt(int x) {
//        long left = 0;
//        long right = x / 2 + 1;
//        while (left <= right) {
//            long mid = (left + right) / 2;
//            long sqrt = mid * mid;
//            if (sqrt < x) {
//                left = mid + 1;
//            } else if (sqrt > x) {
//                right = mid - 1;
//            } else {
//                return (int)mid;
//            }
//        }
//        return (int)right;
//    }

    /**
     * X(0) = 0, X(1) = 1
     * X(i+1) = (X(i) + X / X(i)) / 2;
     * X(i) == X(i+1), merely equal
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
//        int a = 2;
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(10));
//        for (int i :
//                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {

//            System.out.println(i + ": " + solution.mySqrt(i));
//        }
    }
}
