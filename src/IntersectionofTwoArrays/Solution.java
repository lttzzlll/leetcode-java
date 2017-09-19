package IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liutaotao on 2017/9/19.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        Set<Integer> arr = new HashSet<>(nums1.length);
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                arr.add(i);
            }
        }
        int[] res = new int[arr.size()];
        int pos = 0;
        for (int i : arr) {
            res[pos++] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1};
        int[] nums = new int[]{2, 2};
        Solution solution = new Solution();
        int[] res = solution.intersection(arr, nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
