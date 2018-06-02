package NumberofLongestIncreasingSubsequence;

/**
 * Created by liutaotao on 2018/6/1.
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLen = 1;
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 3, 5, 2, 4, 1, 5, 7};
        Solution solution = new Solution();
        System.out.println(solution.findNumberOfLIS(nums));
    }
}
