package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liutaotao on 2017/11/30.
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, 0, res);
        return res;
    }

    /**
     * 1 2 3
     * 1 3 2
     * 2 1 3
     * 2 3 1
     * 3 1 2
     * 3 2 1
     */

    private void perm(int[] nums, int start, List<List<Integer>> res) {
        // n个元素一定,前n个位置上的元素确定了,最后一个位置上的元素自然确定了
        if (start == nums.length - 1) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            perm(nums, start + 1, res);
//            swap(nums, start, i);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(arr);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
