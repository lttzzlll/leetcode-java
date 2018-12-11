package LargestNumberAtLeastTwiceofOthers;

import javax.print.attribute.SetOfIntegerSyntax;

public class Solution {
    public int dominantIndex(int[] nums) {
        int pos = -1;
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                pos = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return max >= second * 2 ? pos : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 6, 1, 0 };
        Solution s = new Solution();
        System.out.println(s.dominantIndex(nums));
    }
}