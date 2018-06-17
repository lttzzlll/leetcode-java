package FindSmallestLetterGreaterThanTarget;

import java.util.Arrays;

/**
 * Created by liutaotao on 2018/6/17.
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int cnt = 1;
        char lastChar = letters[0];
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == lastChar) continue;
            lastChar = letters[i];
            cnt++;
        }
        char[] ret = new char[cnt];
        ret[0] = letters[0];
        int idx = 0;
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] != ret[idx]) ret[++idx] = letters[i];
        }
        int pos = Arrays.binarySearch(ret, target);

        if (pos < 0) {
            pos = -(pos + 1);
            return ret[pos % cnt];
        } else {
            return ret[(pos + 1) % cnt];
        }
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
//        char[] letters = new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(letters, 'k'));
    }
}
