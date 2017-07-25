package RotateArray;

import java.util.Arrays;

/**
 * Created by 10609 on 2017/7/25.
 */
public class Solution {

    private void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k %= nums.length;
        }
        int m = nums.length - k;
        rotate(nums, 0, m - 1);
        rotate(nums, m, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        for (int i = 0; i < nums.length; i++) {
            int[] arr = Arrays.copyOf(nums, nums.length);
            solution.rotate(arr, i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(String.format("%4d", arr[j]));
            }
            System.out.println();
        }
    }
}
