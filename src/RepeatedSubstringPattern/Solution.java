package RepeatedSubstringPattern;

/**
 * Created by liutaotao on 2018/5/23.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 2; i <= len; i++) {
            if (len % i == 0) {
                int step = len / i;
                boolean flag = true;
                for (int j = step; j < len; j += step) {
                    if (!s.substring(j - step, j).equals(s.substring(j, j + step))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String str = "abaababaab";
//        String str = "abcabcabc";
//        String str = "bb";
        String str = "ababab";
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern(str));
    }
}
