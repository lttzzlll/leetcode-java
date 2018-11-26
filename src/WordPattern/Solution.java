package WordPattern;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        return false;
    }

    public static void main(String args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        Solution s = new Solution();
        boolean t = s.wordPattern(pattern, str);
        System.out.println(t);
    }
}
