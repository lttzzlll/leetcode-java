package AddDigits;


import java.sql.SQLSyntaxErrorException;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {
    private int avg(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        while ((num = avg(num)) >= 10) {
            num = avg(num);
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 10;
//        int num = 38;
        Solution solution = new Solution();
        int res = solution.addDigits(num);
        System.out.println(res);
    }
}
