package LongestContinuousIncreasingSubsequence;

/**
 * Created by liutaotao on 2018/6/1.
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] > maxLen) maxLen = dp[i];
            } else dp[i] = 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 6};
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(nums));
    }
}
