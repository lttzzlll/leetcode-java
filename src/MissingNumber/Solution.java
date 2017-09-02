package MissingNumber;

/**
 * Created by liutaotao on 2017/9/2.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ nums.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0};
        Solution s = new Solution();
        System.out.println(s.missingNumber(arr));
    }
}
