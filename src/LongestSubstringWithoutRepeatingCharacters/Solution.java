package LongestSubstringWithoutRepeatingCharacters;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 10609 on 2017/7/21.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }
        int maxLen = 0;
        Map<Character, Integer> map =  new HashMap<Character, Integer>();
        for (int i = 0, startPoint = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                startPoint = Math.max(startPoint, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - startPoint + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
