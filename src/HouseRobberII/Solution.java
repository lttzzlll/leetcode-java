package HouseRobberII;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Integer.max(nums[0], nums[1]);
        int maxlen = 0;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Integer.max(dp[0], nums[1]);
        for (int i = 2; i < length - 1; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        maxlen = dp[length - 2];
        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = Integer.max(dp[1], nums[2]);
        for (int i = 3; i < length; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        maxlen = Integer.max(maxlen, dp[length - 1]);
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 1, 1, 2 };
        Solution solution = new Solution();
        int maxlen = solution.rob(nums);
        System.out.println(maxlen);
    }
}