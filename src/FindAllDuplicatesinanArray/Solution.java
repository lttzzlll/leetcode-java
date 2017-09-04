package FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10609 on 2017/9/4.
 */
public class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            if (i + 1 == nums[nums[i] - 1])
                res.add(i + 1);
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
