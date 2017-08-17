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

//    public boolean isMatch(String s, int i, String p, int j) {
//        if (s.length() == i) { // s goes to the end
//            return p.length() == j || // p goes to the end also
//                    // both s and p are go to the end
//
//                    // if s goes to the end, but p not, then we do not care about p[j]
//                    // but pay attention on p[j+1], and it must be '*', which means the number
//                    // of p[j] can be 0, 1, 2 ... So, we should make sure p.length() > j + 1,
//                    // at least p.length() == j + 2
//                    // and be sure that the following sequence must be correct matched!
//                    (p.length() > j + 1 && p.charAt(j+1) == '*' && isMatch(s, i, p, j + 2));
//        }
//        // s not goes to end
//        // special condition: p[j+1] == '*'
//        if (p.length() > j + 1 && p.charAt(j + 1) == '*') {
//            // s[i] == p[j] or p[j] == '.' equals s[i]
//            if (s.charAt(i) ==  p.charAt(j) || p.charAt(j) == '.') {
//                // go to next epoch, condition: s[j] == s[j+1], so p should not go to next position
//                // OR: s[j] != s[j+1], then, p should go to the next position, AND
//                // the next position is p[j+2]. cause p[j+1] is '*', itself can not match any characters
//                return isMatch(s, i + 1, p, j) || isMatch(s, i, p, j + 2);
//            } else {
//                // s[i] != p[j], but p[j + 1] == '*', so we can treat p[j] as '' Empty, just jump and ignore it
//                // AND go to the next position to match the following sequence
//                return isMatch(s, i, p, j + 2);
//            }
//        } else { // p[j+1] is not '*'
//            // if s[i] == p[j], then go to the next position
//            if (p.length() > j && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
//                return isMatch(s, i + 1, p, j + 1);
//            } else  { // does not match, return false
//                return false;
//            }
//        }
//    }
//
//    public boolean isMatch(String s, String p) {
//        return isMatch(s, 0, p, 0);
//    }

//
//    public boolean matchFirst(char s, char p, int len, int pos) {
//        return s == p || (p == '.' && len > pos);
//    }
//
//    public boolean isMatch(String s, int i, String p, int j) {
//        if (p.length() <= j) return s.length() == i;
//        if (p.length() > j + 1 && p.charAt(j + 1) != '*') {
//            if (s.length() > i && !matchFirst(s.charAt(i), p.charAt(j), s.length(), i)) return false;
//            return isMatch(s, i + 1, p, j + 1);
//        } else {
//            if (isMatch(s, i, p, j + 2)) return true;
//            while (s.length() > i && matchFirst(s.charAt(i), p.charAt(j), s.length(), i)) {
//                ++i;
//                if (isMatch(s, i + 1, p, j + 2)) return true;
//            }
//            return false;
//        }
//    }
//
//    public boolean isMatch(String s, String p) {
//        return isMatch(s, 0, p, 0);
//    }

    /**
     * code: the shorter, the better
     *
     * @param s input string
     * @param p input Regular Expression Pattern
     * @return match or not, true of false
     */
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//        int slen = s.length();
//        int plen = p.length();
//        boolean[][] dp = new boolean[slen + 1][plen + 1];
//        dp[0][0] = true;
//        for (int i = 0; i < plen; i++) {
//            if (p.charAt(i) == '*' && dp[0][i - 1]) {
//                dp[0][i + 1] = true;
//            }
//        }
//
//        for (int i = 0; i < slen; i++) {
//            for (int j = 0; j < plen; j++) {
//                // determine dp[i][j]
//                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
//                    dp[i + 1][j + 1] = dp[i][j];
//                }
//                // determine dp[i + 1][j + 1]
//                if (p.charAt(j) == '*') {
//                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
//                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
//                    } else {
//                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
//                    }
//                }
//            }
//        }
//        return dp[slen][plen];
//    }
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray());
    }

    public boolean isMatch(char[] s, char[] p) {
        int m = s.length, n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            (i > 0 && (s[i - 1] == p[j - 2] || p[j - 2] == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "aa";
        String b = "a";
        Solution solution = new Solution();
        boolean res = solution.isMatch(a, b);
        System.out.println(res);
    }

}