package PowerofThree;

import java.util.HashSet;

/**
 * Created by liutaotao on 2018/4/23.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        int i = 1;
        while (i < Integer.MAX_VALUE && i > 0) {
            set.add(i);
            i *= 3;
        }
        return set.contains(n);
    }

    static void test() {
        int n = 1;
        while (n < Integer.MAX_VALUE && n > 0) {
            System.out.println(n + ": " + Integer.toBinaryString(n));
            n *= 3;
        }
    }

    public static void main(String[] args) {
        test();
    }
}
