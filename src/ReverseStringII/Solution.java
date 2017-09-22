package ReverseStringII;

/**
 * Created by liutaotao on 2017/9/22.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmn";
        Solution solution = new Solution();
        System.out.println(solution.reverseStr(s, 3));
    }
}
