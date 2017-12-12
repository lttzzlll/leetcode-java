package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liutaotao on 2017/12/4.
 */
public class Solution {
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    private void perm(int[] num, int start, List<List<Integer>> res) {
        if (start == num.length - 1) {
            res.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[start]) continue;
            swap(num, i, start);
            perm(Arrays.copyOf(num, num.length), start + 1, res);
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        perm(num, 0, res);
        return res;
    }

    static void printArr(int[] num) {
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(num);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
