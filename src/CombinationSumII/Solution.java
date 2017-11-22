package CombinationSumII;

import java.util.*;

/**
 * Created by liutaotao on 2017/11/22.
 */
public class Solution {
    private void dis(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private void dis(List<Integer> nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void dis(List<Integer> nums, int pos) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println(" | " + pos);
    }

    private boolean same(List<Integer> left, List<Integer> right) {
        if (left.size() != right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static String toStr(List<Integer> nums) {
        String str = "";
        for (int i : nums) {
            str += i;
        }
        return str;
    }

    HashSet<String> set = new HashSet<>();

    private void solve(List<List<Integer>> res, List<Integer> cur, int[] nums, int start, int target) {
        if (target == 0) {
            String str = toStr(cur);
            if (!set.contains(str)) {
                res.add(new ArrayList<>(cur));
                set.add(str);
            }
        } else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                solve(res, cur, nums, i + 1, target - nums[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 1 1 2 5 6 7 10
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        solve(res, cur, candidates, 0, target);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();

        List<List<Integer>> res = solution.combinationSum2(arr, target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
