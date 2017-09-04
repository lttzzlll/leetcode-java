package ValidParentheses;

import java.util.Stack;

/**
 * Created by liutaotao on 2017/8/28.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c :
                s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char t = stack.pop();
                    if (!(t == '[' && c == ']' ||
                          t == '(' && c == ')' ||
                          t == '{' && c == '}')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()[]{}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
