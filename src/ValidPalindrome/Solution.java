package ValidPalindrome;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left  < right && !Character.isLetterOrDigit(arr[left])) left++;
            while (left < right && !Character.isLetterOrDigit(arr[right])) right--;
            if (left < right && arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = "";
        String s = ".,";
        Solution solution = new Solution();
        boolean res = solution.isPalindrome(s);
        System.out.println(res);
    }
}
