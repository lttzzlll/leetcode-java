package LengthofLastWord;

/**
 * Created by liutaotao on 2017/12/13.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] arr = s.split(" ");
        int pos = arr.length - 1;
        while (pos >= 0 && arr[pos].length() == 0) pos--;

        return pos >= 0 ? arr[pos].length() : 0;
    }

    static void print(String[] arr) {
        for (String s : arr) {
            System.out.println("[" + s + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "hello world";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(s));
    }
}
