package ReverseVowelsofaString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2017/9/23.
 */
public class Solution {
    List<Character> vowels;

    public Solution() {
        vowels = new ArrayList<>(10);
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int left = 0, right = res.length - 1;
        while (left < right) {
            if (!vowels.contains(res[left])) {
                left++;
            } else if (!vowels.contains(res[right])) {
                right--;
            } else {
                char temp = res[left];
                res[left] = res[right];
                res[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
//        String s = "hello";
//        String s = "leetcode";
        String s = "aA";
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels(s));
    }
}
