package PalindromeNumber;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] arr = String.valueOf(x).toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 0;
        Solution solution = new Solution();
        boolean res = solution.isPalindrome(x);
        System.out.println(res);
    }
}
