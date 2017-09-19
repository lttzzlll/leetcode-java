package FindtheDifference;

/**
 * Created by liutaotao on 2017/9/19.
 */
public class Solution {
//    private int sum(String s) {
//        int res = 0;
//        for (char c : s.toCharArray()) {
//            res += c;
//        }
//        return res;
//    }
//
//    public char findTheDifference(String s, String t) {
//        return (char)(sum(t) - sum(s));
//    }


    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference(s, t));
    }
}
