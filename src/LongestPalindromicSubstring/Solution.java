package LongestPalindromicSubstring;

/**
 * Created by 10609 on 2017/7/24.
 */
public class Solution {

    private String preProcess(String s) {
        char[] arr = new char[s.length() * 2 + 3];
        arr[0] = '^';
        arr[arr.length - 1] = '$';
        boolean flag = true;
        int idx = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (flag) {
                arr[i] = '#';
            } else {
                arr[i] = s.charAt(idx++);
            }
            flag = !flag;
        }
        return String.valueOf(arr);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        String str = preProcess(s);
        int n = str.length();
        int id = 0, mx = 0;
        int[] p = new int[n];
        for (int i = 1; i < n - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (str.charAt(i + p[i]) == str.charAt(i - p[i])) p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }

        int maxLen = 0, index = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                index = i;
            }
        }

        return s.substring((index - maxLen) / 2, maxLen - 1 + (index - maxLen) / 2);
    }

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution solution = new Solution();
        String res = solution.longestPalindrome(s);
        System.out.println(res);
    }
}
