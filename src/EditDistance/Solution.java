package EditDistance;

/**
 * Created by liutaotao on 2017/8/30.
 */
public class Solution {
    private int[][] dp = null;

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

//    private int f(char[] a, int i, char[] b, int j) {
//        if (a.length == i) return b.length - j;
//        else if (b.length == j) return a.length - i;
//        if (a[i] == b[j]) return f(a, i + 1, b, j + 1);
//        else return 1 + min(f(a, i + 1, b, j + 1), f(a, i, b, j + 1), f(a, i + 1, b, j));
//    }

    private int f(char[] a, int i, char[] b, int j) {
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        if (a.length == i) {
            dp[i][j] = b.length - j;
            return dp[i][j];
        } else if (b.length == j) {
            dp[i][j] = a.length - i;
            return dp[i][j];
        }
        if (a[i] == b[j]) {
            dp[i][j] = f(a, i + 1, b, j + 1);
            return dp[i][j];
        } else {
            dp[i][j] = 1 + min(f(a, i + 1, b, j + 1), f(a, i, b, j + 1), f(a, i + 1, b, j));
            return dp[i][j];
        }
    }


    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return f(word1.toCharArray(), 0, word2.toCharArray(), 0);
    }

    public static void main(String[] args) {
//        String a = "dinitrophenylhydrazine";
//        String b = "acetylphenylhydrazine";
//        String a = "dinitrophenylhy";
//        String b = "acetylphenylhy";
        String a = "a";
        String b = "ab";
        System.out.println(a.length());
        System.out.println(b.length());
        Solution solution = new Solution();
        System.out.println(solution.minDistance(a, b));
    }
}
