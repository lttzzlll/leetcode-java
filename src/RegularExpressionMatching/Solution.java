import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        boolean res = m.matches();
        return res;
    }
}