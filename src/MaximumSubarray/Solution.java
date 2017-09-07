package MaximumSubarray;


/**
 * Created by liutaotao on 2017/9/7.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int res = sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            if (sum[i] > res) res = sum[i];
//            System.out.println(String.format("sum[%d]: %d", i, sum[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(arr));
    }
}
