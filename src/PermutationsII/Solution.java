package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liutaotao on 2017/12/4.
 */
public class Solution {
    HashSet<String> set = new HashSet<>();
    private String arrToString(int[] nums) {
        StringBuilder sb = new StringBuilder(nums.length);
        for (int i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void perm(int[] nums, int start, List<List<Integer>> res, boolean[] used) {
        if (start == nums.length) {
//            String str = arrToString(nums);
//            if (set.contains(str)) return;
//            set.add(str);
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
//            if (used[i]) continue;
            if (i > start && nums[i] == nums[start]) continue;
            swap(nums, i, start);
            used[i] = true;
            perm(nums, start + 1, res, used);
            swap(nums, i, start);
            used[i] = false;
        }
    }

    /**
     * 1 1 2 2
     * 1 2 1 2
     * 1 2 2 1
     * 1 2 1 2
     * 2 1 1 2
     * 2 1 2 1
     * 2 2 1 1
     * 2 1 2 1
     * 2 1 1 2
     * 2 2 1 1
     */


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        perm(nums, 0, res, used);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 2, 4, 5, 6};
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        List<List<Integer>> res = solution.permuteUnique(nums);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
