package MaximumProductSubarray;

/**
 * Created by liutaotao on 2017/9/6.
 */
public class Solution {
//    private void disp(int[][] dp) {
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = i + 1; j < dp[i].length; j++) {
//                System.out.println(String.format("(%d, %d): %d", i, j, dp[i][j]));
//            }
//        }
//    }
//
//    private int max(int a, int b, int c, int d) {
//        return Math.max(Math.max(a, b), Math.max(c, d));
//    }
//
//    private int max(int a, int b) {
//        return Math.max(a, b);
//    }
//
//    public int maxProduct(int[] nums) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int[][] dp = new int[nums.length + 1][nums.length + 1];
//        int[][] odds = new int[nums.length + 1][nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i][i] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= 0) {
//                odds[i][i] = 1;
//            }
//        }
//        for (int stepLen = 2; stepLen <= nums.length; stepLen++) {
//            for (int i = 0; i + stepLen <= nums.length; i++) {
//                if (odds[i][i + stepLen - 1] % 2 == odds[i + 1][i + stepLen - 1] % 2) {
//                    dp[i][i + stepLen - 1] = max(dp[i][i + stepLen - 2],
//                            dp[i][i + stepLen - 2] * nums[i + stepLen - 1],
//                            nums[i] * dp[i + 1][i + stepLen - 1],
//                            dp[i + 1][i + stepLen - 1]);
//                } else {
//                    dp[i][i + stepLen - 1] = max(dp[i][i + stepLen - 2],
//                            dp[i + 1][i + stepLen - 1],
//                            nums[i],
//                            nums[i + stepLen - 1]);
//                }
//
//                System.out.println(String.format("(%d, %d): %d", i, i + stepLen - 1, dp[i][i + stepLen - 1]));
//            }
//        }
////        disp(dp);
//        return dp[nums.length][nums.length];
//    }

//    public int maxProduct(int[] nums) {
//        int res = nums[0], max = nums[0], min = nums[0];
//        System.out.println(String.format("num: %d, max: %d, min: %d", nums[0], max, min));
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < 0) {
//                int temp = max;
//                max = min;
//                min = temp;
//            }
//            max = Math.max(nums[i], max * nums[i]);
//            min = Math.min(nums[i], min * nums[i]);
//            System.out.println(String.format("num: %d, max: %d, min: %d", nums[i], max, min));
//            if (max > res) res = max;
//        }
//        return res;
//    }

    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], nums[i] > 0 ? nums[i] * max[i - 1] : nums[i] * min[i - 1]);
            min[i] = Math.min(nums[i], nums[i] > 0 ? nums[i] * min[i - 1] : nums[i] * max[i - 1]);
            res = Math.max(Math.max(max[i], min[i]), res);
            System.out.println(String.format("max: %d, min: %d", max[i], min[i]));
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, -100, -4, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(arr));
    }
}
