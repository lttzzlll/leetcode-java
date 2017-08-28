package LongestCommonPrefix;

/**
 * Created by liutaotao on 2017/8/26.
 */
public class Solution {

    private boolean check(String[] strs, int position) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].charAt(position) != strs[i + 1].charAt(position)) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        for (int i = 0; i < minLen; i++) {
            if (!check(strs, i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"hello", "hey", "how are you"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
