package HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        else if (length == 1)
            return nums[0];
        else if (length == 2)
            return Integer.max(nums[0], nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 1 };
        // int[] nums = { 2, 7, 9, 3, 1 };
        int[] nums = { 2, 1, 1, 2 };
        Solution solution = new Solution();
        int r = solution.rob(nums);
        System.out.println(r);
    }
}
