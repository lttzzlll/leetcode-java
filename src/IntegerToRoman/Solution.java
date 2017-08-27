package IntegerToRoman;

/**
 * Created by liutaotao on 2017/8/24.
 */
public class Solution {
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String res = "";
        res += roman[3][num / 1000];
        res += roman[2][num / 100 % 10];
        res += roman[1][num / 10 % 10];
        res += roman[0][num % 10];
        return res;
    }
    public static void main(String[] args) {
        int num = 3421;
        Solution solution = new Solution();
        String res = solution.intToRoman(num);
        System.out.println(res);
    }
}
