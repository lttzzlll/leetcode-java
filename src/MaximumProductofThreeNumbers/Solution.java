package MaximumProductofThreeNumbers;

/**
 * Created by liutaotao on 2017/9/5.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) return 0;
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -3, -2, -1, 60};
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(arr));
    }
}
