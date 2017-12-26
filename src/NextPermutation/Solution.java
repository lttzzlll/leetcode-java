package NextPermutation;

/**
 * Created by liutaotao on 2017/12/22.
 */
public class Solution {
    static void swap(int[] num, int i, int j) {
        if (i != j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }


    static void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) break;
            i--;
        }
        if (i > 0) {
            int x = nums.length - 1;
            while (x >= i) {
                if (nums[x] > nums[i - 1]) break;
                x--;
            }
            swap(nums, i - 1, x);
        }
        reverse(nums, i, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 1};
        Solution solution = new Solution();
        solution.nextPermutation(num);
        for (int i : num) {
            System.out.printf("%2d", i);
        }
        System.out.println();
    }
}
