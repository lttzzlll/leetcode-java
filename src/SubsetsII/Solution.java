package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liutaotao on 2018/7/21.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                ArrayList<Integer> arr = new ArrayList<>(list.get(j));
                arr.add(nums[i]);
                String str = Arrays.toString(arr.toArray());
                if (set.contains(str)) continue;
                list.add(arr);
                set.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 2};
        int[] nums = new int[]{4, 4, 4, 1, 4};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsetsWithDup(nums);
        for (List<Integer> lst : res) {
            for (int i : lst) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
