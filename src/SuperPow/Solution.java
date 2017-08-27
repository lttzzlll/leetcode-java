package SuperPow;

import java.util.Stack;

/**
 * Created by liutaotao on 2017/8/26.
 */
public class Solution {
    private static final int base = 1337;

    private int powmod(int a, int k) {
        System.out.println(a + " : " + k);
        a %= base;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % base;
        }
        return result;
    }

    private int pow(int a, Stack<Integer> b) {
        if (b.isEmpty()) {
            return 1;
        }
        int last_digit = b.pop();
        return powmod(pow(a, b), 10) * powmod(a, last_digit) % base;
    }

    public int superPow(int a, int[] b) {
        Stack<Integer> bb = new Stack<Integer>();
        for (int i : b) {
            bb.push(i);
        }
        return pow(a, bb);
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = new int[]{2, 0, 0};
        Solution solution = new Solution();
        System.out.println(solution.superPow(a, b));
    }
}
