package ReverseWordsinaStringIII;

/**
 * Created by liutaotao on 2017/9/22.
 */
public class Solution {
//    private String reverse(String s) {
//        char[] res = s.toCharArray();
//        int left = 0, right = s.length() - 1;
//        while (left < right) {
//            char temp = res[left];
//            res[left] = res[right];
//            res[right] = temp;
//            left++;
//            right--;
//        }
//        return String.valueOf(res);
//    }
//
//    public String reverseWords(String s) {
//        String res[] = s.split(" ");
//        for (int i = 0; i < res.length - 1; i++) {
//            res[i] = reverse(res[i]) + " ";
//        }
//        res[res.length - 1] = reverse(res[res.length - 1]);
//        StringBuilder sb = new StringBuilder();
//        for (String str : res) {
//            sb.append(str);
//        }
//        return sb.toString();
//    }


    public String reverseWords(String s) {
        String[] res = s.split(" ");
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder(res[i]).reverse() + " ";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : res) {
            sb.append(str);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "may be that's a wonderful day!";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }
}
