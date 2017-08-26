package SumofSquareNumbers;

/**
 * Created by liutaotao on 2017/8/25.
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        int mid = (int) Math.sqrt(c);
        for (int i = 0; i <= mid; i++) {
            int div = c - i * i;
            int temp = (int) Math.sqrt(div);
            int res = temp * temp;
            if (res > div) {
                return false;
            }
            if (res == div) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 5;
        Solution solution = new Solution();
//        for (int i = 0; i < 100; i++) {
//            boolean res = solution.judgeSquareSum(i);
//            System.out.println(i + " : " + res);
//        }
        boolean res = solution.judgeSquareSum(a);
        System.out.println(res);
    }
}
