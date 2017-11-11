package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2017/11/11.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> list,
                           String str,
                           int open,
                           int close,
                           int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(n);
        for (String str: res) {
            System.out.println(str);
        }
    }
}
