package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liutaotao on 2017/12/4.
 */
public class Solution {
    private String arrToString(int[] nums) {
        StringBuilder sb = new StringBuilder(nums.length);
        for (int i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void perm(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[start]) continue;
            swap(nums, i, start);
            perm(nums, start + 1, res);
            swap(nums, i, start);
        }
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        perm(nums, 0, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
