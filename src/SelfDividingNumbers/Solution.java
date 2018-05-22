package SelfDividingNumbers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/5/22.
 */
public class Solution {
    static boolean isDivid(int m) {
        int n = m;
        while (n > 0) {
            int t = n % 10;
            if (t == 0) return false;
            if (m % t != 0) return false;
            n /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isDivid(i)) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = s.selfDividingNumbers(1, 22);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
