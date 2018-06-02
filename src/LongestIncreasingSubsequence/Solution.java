package LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Created by liutaotao on 2018/6/2.
 */
public class Solution {
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < dp.length; i++) {
//            int len = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) len = Math.max(len, dp[j] + 1);
//            }
//            dp[i] = len;
//        }
//        int maxLen = 0;
//        for (int i : dp) {
//            if (i > maxLen) maxLen = i;
//        }
//        return maxLen;
//    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] seq = new int[nums.length];
        int seqLen = 0;
        seq[seqLen++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq[seqLen - 1]) seq[seqLen++] = nums[i];
            else {
                int idx = Arrays.binarySearch(seq, 0, seqLen, nums[i]);
                if (idx < 0) idx = -(idx + 1);
                seq[idx] = nums[i];
            }
        }
        return seqLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//        System.out.println(Arrays.binarySearch(arr, 0));
    }
}
