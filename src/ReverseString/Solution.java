package ReverseString;

/**
 * Created by liutaotao on 2017/9/22.
 */
public class Solution {

//    public String reverseString(String s) {
//        char[] res = new char[s.length()];
//        int pos = s.length() - 1;
//        for (char c : s.toCharArray()) {
//            res[pos--] = c;
//        }
//        return String.valueOf(res);
//    }

    public String reverseString(String s) {
        char[] res = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "hello";
        Solution solution = new Solution();
        System.out.println(solution.reverseString(s));
    }

}
