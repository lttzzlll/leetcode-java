package ContainsDuplicateII;

import java.util.HashMap;

/**
 * Created by liutaotao on 2018/5/18.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i]) && dict.get(nums[i]) + k >= i) return true;
            else dict.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
