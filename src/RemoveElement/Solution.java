package RemoveElement;

/**
 * Created by liutaotao on 2017/8/29.
 */
public class Solution {
    private static void print(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(String.format("%4d", nums[i]));
        }
        System.out.println();
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            if (nums[i] == val) {
                count++;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
            }
            if (nums[i] == val) {
                i--;
            }
        }
        return nums.length - count;
    }


    public static void main(String[] args) {
//        int[] a = new int[]{3, 2, 2, 3};
//        int[]a = new int[]{1};
//        int[] a = new int[]{3, 3};
        int[] a = new int[]{2};
        Solution solution = new Solution();
        int res = solution.removeElement(a, 3);
        System.out.println("length: " + res);
        for (int i = 0; i < res; i++) {
            System.out.println(a[i]);
        }
    }
}
