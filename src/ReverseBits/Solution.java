package ReverseBits;

/**
 * Created by liutaotao on 2017/9/17.
 */
public class Solution {
    // you need treat n as an unsigned value
//    public int reverseBits(int n) {
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            res += n & 1;
//            n >>>= 1;
//            if (i < 31) {
//                res <<= 1;
//            }
//        }
//        return res;
//    }

    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res++;
            n >>>= 1; // n 这里补0补1都无所谓,因为根本用不到它
        }
        return res;
    }

    public static void main(String[] args) {
//        int n = 43261596;
        int n = 1;
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(n));
    }
}
