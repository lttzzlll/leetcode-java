package RemoveDuplicatesfromSortedArray;

/**
 * Created by liutaotao on 2017/8/29.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int i = 1, count = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i == nums.length) {
                break;
            } else {
                nums[count++] = nums[i++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8};
//        int[] a = new int[]{1, 2};
//        int[] a = new int[]{1, 1, 2};
        Solution solution = new Solution();
        int len = solution.removeDuplicates(a);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
    }
}
