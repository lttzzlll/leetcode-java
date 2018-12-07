package WordPattern;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String []arr = str.split(" ");
        if (arr.length != pattern.length()) return false;

        HashMap<Character, String> map = new HashMap<>(pattern.length());
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(pattern.charAt(i))) map.remove(pattern.charAt(i));
            else map.put(pattern.charAt(i), arr[i]);
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat dog cat";
        Solution s = new Solution();
        boolean t = s.wordPattern(pattern, str);
        System.out.println(t);
    }
}
