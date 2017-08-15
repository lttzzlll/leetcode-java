package RegularExpressionMatching;

public class Solution {
//    public boolean isMatch(String s, String p) {
//        Pattern pattern = Pattern.compile(p);
//        Matcher m = pattern.matcher(s);
//        boolean res = m.matches();
//        return res;
//    }
//    public boolean isMatch(String s, String p){
//        boolean[] match = new boolean[s.length() + 1];
//        match[s.length()] = true;
//        for (int i = p.length() - 1; i >= 0; i--) {
//            if (p.charAt(i) == '*') {
//                for (int j = s.length() - 1; j >= 0; j--) {
//                    match[j] = match[j] || (match[j + 1] && p.charAt(i - 1) == '.' || (p.charAt(i - 1) == s.charAt(j)));
//                }
//                i--;
//            } else {
//                for (int j = 0; j < s.length(); j++) {
//                    match[j] = match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
//                }
//                match[s.length()] = false;
//            }
//        }
//        return match[0];
//    }

//    public boolean isMatch(String s, String p) {
//        if (s.length() == 0) {
//            return true;
//        }
//        if (p.length() == 0) {
//            return false;
//        }
//        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
//            if (p.length() == 1) {
//                return isMatch(s.substring(1), p.substring(1));
//            } else {
//                if (p.charAt(1) == '*') {
//                    return isMatch(s.substring(1), p);
//                } else {
//                    return isMatch(s.substring(1), p.substring(1));
//                }
//            }
//        } else {
//            return false;
//        }
//    }

    public boolean isMatch(String s, int i, String p, int j) {
        if (s.length() == i) { // s goes to the end
            return p.length() == j || // p goes to the end also
                    // both s and p are go to the end

                    // if s goes to the end, but p not, then we do not care about p[j]
                    // but pay attention on p[j+1], and it must be '*', which means the number
                    // of p[j] can be 0, 1, 2 ... So, we should make sure p.length() > j + 1,
                    // at least p.length() == j + 2
                    // and be sure that the following sequence must be correct matched!
                    (p.length() > j + 1 && p.charAt(j+1) == '*' && isMatch(s, i, p, j + 2));
        }
        // s not goes to end
        // special condition: p[j+1] == '*'
        if (p.length() > j + 1 && p.charAt(j + 1) == '*') {
            // s[i] == p[j] or p[j] == '.' equals s[i]
            if (s.charAt(i) ==  p.charAt(j) || p.charAt(j) == '.') {
                // go to next epoch, condition: s[j] == s[j+1], so p should not go to next position
                // OR: s[j] != s[j+1], then, p should go to the next position, AND
                // the next position is p[j+2]. cause p[j+1] is '*', itself can not match any characters
                return isMatch(s, i + 1, p, j) || isMatch(s, i, p, j + 2);
            } else {
                // s[i] != p[j], but p[j + 1] == '*', so we can treat p[j] as '' Empty, just jump and ignore it
                // AND go to the next position to match the following sequence
                return isMatch(s, i, p, j + 2);
            }
        } else { // p[j+1] is not '*'
            // if s[i] == p[j], then go to the next position
            if (p.length() > j && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return isMatch(s, i + 1, p, j + 1);
            } else  { // does not match, return false
                return false;
            }
        }
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }



    public static void main(String[] args) {
        String a = "aa";
        String b = "a";
        Solution solution = new Solution();
        boolean res = solution.isMatch(a, b);
        System.out.println(res);
    }

}