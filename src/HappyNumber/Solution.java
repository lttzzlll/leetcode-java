package HappyNumber;

import java.util.HashSet;

/**
 * Created by liutaotao on 2018/5/14.
 */
public class Solution {
    HashSet<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (set.contains(n)) return false;
        set.add(n);
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        if (sum == 1) return true;
        return isHappy(sum);
    }


    public static void main(String[] args) {
        int n = 8;
        Solution solution = new Solution();
        System.out.println(solution.isHappy(n));
    }
}
