package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liutaotao on 2017/11/21.
 */
public class Solution {
    private void solve(List<List<Integer>> list, List<Integer> cur, int[] nums, int start, int target) {
        if (target == 0) list.add(new ArrayList<Integer>(cur));
        else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                solve(list, cur, nums, i, target - nums[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        solve(res, cur, candidates, 0, target);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(arr, target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
