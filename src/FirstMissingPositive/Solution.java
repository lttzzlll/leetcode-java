package FirstMissingPositive;

/**
 * Created by liutaotao on 2017/9/2.
 */
public class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 4, -1, 1};
        int[] arr = new int[]{1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(arr));
    }
}
