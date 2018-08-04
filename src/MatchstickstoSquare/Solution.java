package MatchstickstoSquare;

import java.util.HashSet;

/**
 * Created by liutaotao on 2018/7/25.
 */
public class Solution {
    boolean dfs(HashSet<Integer> used, int[] nums, int pos, int sum, int leftSides, int target) {
        if (leftSides == 0) return true;
        if (sum == target) return dfs(used, nums, 0, 0, leftSides - 1, target);
        for (int i = pos; i < nums.length; i++) {
            if (used.contains(i)) continue;
            if (nums[i] + sum > target) continue;
            used.add(i);
            if (dfs(used, nums, i + 1, sum + nums[i], leftSides, target)) return true;
            used.remove(i);
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 4 != 0) return false;
        return dfs(new HashSet<>(nums.length), nums, 0, 0, 4, sum / 4);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2};
        Solution solution = new Solution();
        boolean res = solution.makesquare(nums);
        System.out.println(res);
    }
}
