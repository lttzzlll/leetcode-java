package twoSum;


import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(nums[i])) {
                return new int[] {
                    i, indices.get(nums[i])
                } ;
            }
            indices.put(target - nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, 9);
        if (res.length > 1) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(String.format("%4d", res[i]));
            }
            System.out.println();
        }
    }

}
