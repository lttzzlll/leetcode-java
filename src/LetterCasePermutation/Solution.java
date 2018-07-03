package LetterCasePermutation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/6/17.
 */
public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new LinkedList<>();
        list.add(S);
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                map.put(i, S.charAt(i));
            }
        }
        for (int i : map.keySet()) {
            char c = map.get(i);
            String s = S.substring(0, i) + c + S.substring(i + 1);
            if (!s.equals(S)) list.add(s);
            if (Character.isUpperCase(c)) {

            }
        }
        return list;
    }

    public static void main(String[] args) {
        String S = "a1b2";
        Solution solution = new Solution();
        List<String> list = solution.letterCasePermutation(S);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
