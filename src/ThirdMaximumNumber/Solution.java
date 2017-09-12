package ThirdMaximumNumber;

/**
 * Created by liutaotao on 2017/9/8.
 */
public class Solution {

    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int first = nums[0], second = first, third = second;
        int i = 1;
        while (i < nums.length) {
            if (first != second && second != third) break;
            if (nums[i] == first || nums[i] == second || nums[i] == third) continue;

            if (nums[i] > first) {
                if (second != first)
                    second = first;
                first = nums[i];
                continue;
            }
            if (nums[i] > second) {
                if (third != second)
                    third = second;
                second = nums[i];
                continue;
            }
            i++;
        }

        for (i = 1; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                if (nums[i] == first) continue;
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                if (nums[i] == second) continue;
                third = nums[i];
            }
        }
        return third;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(arr));
    }
}
