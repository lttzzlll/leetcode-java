package UglyNumber;

/**
 * Created by liutaotao on 2018/5/16.
 */
public class Solution {

    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        if (num % 2 == 0) return isUgly(num / 2);
        if (num % 3 == 0) return isUgly(num / 3);
        if (num % 5 == 0) return isUgly(num / 5);
        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        for (int i = 1; i < 20; i++) {
            System.out.println(i + " " + solution.isUgly(i));
        }
    }
}
