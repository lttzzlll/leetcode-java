package twoSum2;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int curSum = numbers[left] + numbers[right];
            if (curSum < target) left++;
            else if (curSum > target) right--;
            else break;
        }
        return new int[] {left + 1, right + 1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.print(String.format("%4d", res[i]));
        }
        System.out.println();
    }

}
