package FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2017/9/4.
 */
public class Solution {
//    private void swap(int[] nums, int a, int b) {
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }
//
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != nums[nums[i] - 1])
//                swap(nums, i, nums[i] - 1);
//        }
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1)
//                res.add(i + 1);
//        }
//        return res;
//    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            int pos = Math.abs(i) - 1; // dict[number: position]
            if (nums[pos] > 0)
                nums[pos] = -nums[pos];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        Solution solution = new Solution();
        List<Integer> res = solution.findDisappearedNumbers(arr);
        for (Integer i : res) {
            System.out.println(i);
        }
        System.out.println("---------------");
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
