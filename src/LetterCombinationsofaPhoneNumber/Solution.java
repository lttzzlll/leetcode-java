package LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * Created by liutaotao on 2017/9/16.
 */
public class Solution {
    private Map<Character, char[]> digitToChars = new HashMap<>();

    public Solution() {
        digitToChars.put('0', new char[]{});
        digitToChars.put('1', new char[]{});
        digitToChars.put('2', new char[]{'a', 'b', 'c'});
        digitToChars.put('3', new char[]{'d', 'e', 'f'});
        digitToChars.put('4', new char[]{'g', 'h', 'i'});
        digitToChars.put('5', new char[]{'j', 'k', 'l'});
        digitToChars.put('6', new char[]{'m', 'n', 'o'});
        digitToChars.put('7', new char[]{'p', 'q', 'r', 's'});
        digitToChars.put('8', new char[]{'t', 'u', 'v'});
        digitToChars.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    private List<String> merge(List<String> lst, char[] chars) {
        List<String> res = new LinkedList<>();
        if (chars.length == 0) return res;
        if (lst.size() == 0) {
            for (char c : chars) {
                res.add(String.valueOf(c));
            }
            return res;
        } else {
            for (int i = 0; i < lst.size(); i++) {
                String s = lst.get(i);
                res.remove(s);
                for (char c : chars) {
                    res.add(i, s + String.valueOf(c));
                }
            }
            return res;
        }
    }

    public List<String> letterCombinations(String digits) {
        char[] digitChars = digits.toCharArray();
        List<String> res = new LinkedList<>();
        for (char digit : digitChars) {
            char[] chars = digitToChars.get(digit);
            res = merge(res, chars);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution solution = new Solution();
        List<String> res = solution.letterCombinations(digits);
        for (String s : res) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
