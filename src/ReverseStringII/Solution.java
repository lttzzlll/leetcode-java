package ReverseStringII;

/**
 * Created by liutaotao on 2017/9/22.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int min = Math.min(left + k - 1, right); // 2k position
            swap(res, left, min);
            left += 2 * k; // next 2k
        }
        return String.valueOf(res);
    }

    private void swap(char[]arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        Solution solution = new Solution();
        System.out.println(solution.reverseStr(s, 3));
    }
}
