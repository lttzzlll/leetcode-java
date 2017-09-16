package BinaryWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liutaotao on 2017/9/16.
 */
public class Solution {

    private final int[] hours = new int[]{1, 2, 4, 8};
    private final int[] minutes = new int[]{1, 2, 4, 8, 16, 32};

    private static int factorial(int n) {
        int res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }

    private static int permCount(int n, int m) {
        return factorial(n) / (factorial(m) * factorial(n - m));
    }


    private List<Integer> getHours(int n) {
        int count = permCount(4, n);
        List<Integer> res = new ArrayList<>(count);
        switch (n) {
            case 0:
                res.add(0);
                return res;
            case 1: // 4 / 1 = 4
                res.add(1);
                res.add(2);
                res.add(4);
                res.add(8);
                return res;
            case 2: // 4 / 2 = 6
                res.add(1 + 2);
                res.add(1 + 4);
                res.add(1 + 8);
                res.add(2 + 4);
                res.add(2 + 8);
//                res.add(4 + 8);
                return res;
            case 3: // 4 / 3 = 4
                res.add(1 + 2 + 4);
                res.add(1 + 2 + 8);
//                res.add(1 + 4 + 8);
//                res.add(2 + 4 + 8);
                return res;
            case 4: // 4 / 4 = 1
//                res.add(1 + 2 + 4 + 8);
                return res;
        }
        return res;
    }

    private List<Integer> getMinutes(int n) {
        int count = permCount(6, n);
        List<Integer> res = new ArrayList<>(count);
        switch (n) {
            case 0:
                res.add(0);
                return res;
            case 1: // 6 / 1 = 6
                res.add(1);
                res.add(2);
                res.add(4);
                res.add(8);
                res.add(16);
                res.add(32);
                return res;
            case 2: // 6 / 2 = 15
                res.add(1 + 2);
                res.add(1 + 4);
                res.add(1 + 8);
                res.add(1 + 16);
                res.add(1 + 32);
                res.add(2 + 4);
                res.add(2 + 8);
                res.add(2 + 16);
                res.add(2 + 32);
                res.add(4 + 8);
                res.add(4 + 16);
                res.add(4 + 32);
                res.add(8 + 16);
                res.add(8 + 32);
                res.add(16 + 32);
                return res;
            case 3: // 6 / 3 = 20
                res.add(1 + 2 + 4);
                res.add(1 + 2 + 8);
                res.add(1 + 2 + 16);
                res.add(1 + 2 + 32);
                res.add(1 + 4 + 8);
                res.add(1 + 4 + 16);
                res.add(1 + 4 + 32);
                res.add(1 + 8 + 16);
                res.add(1 + 8 + 32);
                res.add(1 + 16 + 32);
                res.add(2 + 4 + 8);
                res.add(2 + 4 + 16);
                res.add(2 + 4 + 32);
                res.add(2 + 8 + 16);
                res.add(2 + 8 + 32);
                res.add(2 + 16 + 32);
                res.add(4 + 8 + 16);
                res.add(4 + 8 + 32);
                res.add(4 + 16 + 32);
                res.add(8 + 16 + 32);
                return res;
            case 4: // 6 / 4 = 15
                res.add(1 + 2 + 4 + 8);
                res.add(1 + 2 + 4 + 16);
                res.add(1 + 2 + 4 + 32);
                res.add(1 + 2 + 8 + 16);
                res.add(1 + 2 + 8 + 32);
                res.add(1 + 2 + 16 + 32);
                res.add(1 + 4 + 8 + 16);
                res.add(1 + 4 + 8 + 32);
                res.add(1 + 4 + 16 + 32);
                res.add(1 + 8 + 16 + 32);
                res.add(2 + 4 + 8 + 16);
                res.add(2 + 4 + 8 + 32);
                res.add(2 + 4 + 16 + 32);
                res.add(2 + 8 + 16 + 32);
//                res.add(4 + 8 + 16 + 32);
                return res;
            case 5: // 6 / 5 = 6
                res.add(1 + 2 + 4 + 8 + 16);
                res.add(1 + 2 + 4 + 8 + 32);
                res.add(1 + 2 + 4 + 16 + 32);
                res.add(1 + 2 + 8 + 16 + 32);
//                res.add(1 + 4 + 8 + 16 + 32);
//                res.add(2 + 4 + 8 + 16 + 32);
                return res;
            case 6: // 6 / 6 = 1
//                res.add(1 + 2 + 4 + 8 + 16 + 32);
                return res;
        }
        return res;
    }

    private List<String> merge(List<Integer> curHours, List<Integer> curMinutes) {
        List<String> res = new ArrayList<>(curHours.size() * curMinutes.size());
        for (int h : curHours) {
            for (int m : curMinutes) {
                String hour = String.valueOf(h);
                String minute = m >= 10 ? String.valueOf(m) : "0" + String.valueOf(m);
                res.add(hour + ":" + minute);
            }
        }
        return res;
    }

    public List<String> readBinaryWatch(int num) {
        int count = permCount(10, num);
        List<String> res = new ArrayList<>(count);
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        for (int i = 0; i <= num; i++) {
            List<Integer> curHours = getHours(i);
            List<Integer> curMinutes = getMinutes(num - i);
            List<String> curList = merge(curHours, curMinutes);
            res.addAll(curList);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        Solution solution = new Solution();
        List<String> res = solution.readBinaryWatch(n);
        for (String s : res) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
