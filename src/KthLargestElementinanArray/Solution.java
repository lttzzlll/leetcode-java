package KthLargestElementinanArray;

/**
 * Created by liutaotao on 2017/9/12.
 */
public class Solution {
    //    private int quickSelect(int[] nums, int left, int right, int k) {
//
//    }
    private int partation(int[] nums, int left, int right) {
        int pivot = nums[(left + right) / 2];
//        System.out.println(String.format("pos:%d, pivot: %d", (left + right) / 2, pivot));
        while (left <= right) {
            while (nums[left] > pivot) left++;
            while (nums[right] < pivot) right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    private void disp(int[] nums) {
        for (int i : nums) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
    }

    private int quickSort(int[] nums, int left, int right) {

        int pivot = partation(nums, left, right);
        System.out.println(String.format("pos: %d, num: %d", pivot, nums[pivot]) + "\n");
        disp(nums);
        if (left < pivot - 1) {
            quickSort(nums, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(nums, pivot, right);
        }

        return -1;
    }

    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(nums, 0, nums.length - 1, k - 1);
//        return quickSort(nums, 0, nums.length - 1);
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[k];
        int pivot = partation(nums, left, right);
//        System.out.println("compare pivot: " + pivot);
//        disp(nums);
        if (k < pivot) {
            return quickSelect(nums, left, (pivot - 1), k);
        } else {
            return quickSelect(nums, pivot, right, k);
        }
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
//        int[] arr = new int[]{3, 7, 4, 5, 8, 6, 9, 4, 5, 2, 1, 7, 4};
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        Solution solution = new Solution();
//        int res = solution.findKthLargest(arr, 2);
        System.out.println(String.format("%dth is %d", 4, solution.findKthLargest(arr, 4)));
        for (int i : arr) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
    }
}
