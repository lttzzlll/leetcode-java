package SearchforaRange;

/**
 * Created by liutaotao on 2017/8/31.
 */
public class Solution {
    private int f(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int mid = f(nums, 0, nums.length - 1, target);
        if (mid == -1) return new int[]{-1, -1};

        int low = mid, high = mid;
        int s = mid, t = mid;
        while (low != -1) {
            s = low;
            low = f(nums, 0, --low, target);
        }

        while (high != -1) {
            t = high;
            high = f(nums, ++high, nums.length - 1, target);
        }

        return new int[]{s, t};
    }

    public static void main(String[] args) {
//        int[] a = new int[]{5, 7, 7, 8, 8, 10};
//        int[] a = new int[]{ 2};
        int[] a = new int[]{
                1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8
        };
        System.out.println(a.length);
        Solution solution = new Solution();
        int[] res = solution.searchRange(a, 8);
        System.out.print(res[0] + " | " + res[1]);
    }
}
