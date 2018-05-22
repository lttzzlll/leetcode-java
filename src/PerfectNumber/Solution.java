package PerfectNumber;

/**
 * Created by liutaotao on 2018/5/22.
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1, stop = num;
        for (int i = 2; i < stop; i++) {
            if (num % i == 0) {
                stop = num / i;
                sum += i;
                sum += stop;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
//        int n = 99999993;
        int n = 28;
        Solution s = new Solution();
        System.out.println(s.checkPerfectNumber(n));
    }
}
