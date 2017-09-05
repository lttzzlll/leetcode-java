package FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // mark the position, but not cover the value
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] < 0)
                res.add(pos + 1);
            nums[pos] *= -1;
        }
        return res;
    }

    public static void main(String[] args) {
        //                    1  2  3  4  3  2  7  8
        int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.findDuplicates(arr);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
