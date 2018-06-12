package SetMismatch;

import java.util.HashMap;

/**
 * Created by liutaotao on 2018/6/12.
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        int len = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) ret[0] = nums[i];
            else map.put(nums[i], Boolean.TRUE);
        }
        for (int i = 1; i <= len; i++) {
            if (!map.containsKey(i)) {
                ret[1] = i;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 2, 4};
//        int[] nums = new int[]{2, 2};
//        int[] nums = new int[]{1, 1};
//        int[] nums = new int[]{3, 2, 2};
        int[] nums = new int[]{8, 7, 3, 5, 3, 6, 1, 4};
        Solution solution = new Solution();
        int[] res = solution.findErrorNums(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
