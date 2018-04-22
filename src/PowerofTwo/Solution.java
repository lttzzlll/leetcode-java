package PowerofTwo;

/**
 * Created by liutaotao on 2018/4/22.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n >>= 1;
        }
        return cnt == 1;
    }

    static void power() {
        for (int i = 0; i < 31; i++) {
            int n = 2 << i;
            System.out.printf("%d << %d = %d == %s\n", 2, i, n, Integer.toBinaryString(n));
        }
    }

    static void move() {
        for (int i = 0; i < 31; i++) {
            int n = 2 << i;
            System.out.println(n + ": " + Integer.toBinaryString(n));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 100; i++) {
            boolean res = solution.isPowerOfTwo(i);
            if (res) {
                System.out.println(i);
            }
//            System.out.println(i + ": " + res);
        }
//        power();
//        move();
    }
}
