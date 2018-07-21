package Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2018/7/14.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        res.add(arr);
        for (int n : nums) {
            int len = res.size();
            for (int i = 0; i < len; i++) {
                ArrayList<Integer> t = new ArrayList<>(res.get(i));
                t.add(n);
                res.add(t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> list = solution.subsets(nums);
        for (List<Integer> lst : list) {
            for (int i : lst) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
