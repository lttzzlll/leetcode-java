package IntersectionofTwoArraysII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liutaotao on 2017/9/19.
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCount = new HashMap<>(nums1.length);
        Map<Integer, Integer> copy = new HashMap<>(nums1.length);
        for (int i : nums1) {
            numCount.put(i, numCount.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            if (numCount.containsKey(i)) {
                copy.put(i, copy.getOrDefault(i, 0) + 1);
            }
        }

        int count = 0;
        for (int i : numCount.keySet()) {
            int temp = Math.min(numCount.get(i), copy.getOrDefault(i, 0));
            numCount.put(i, temp);
            count += temp;
        }
        int[] res = new int[count];
        int pos = 0;
        for (int i : numCount.keySet()) {
            int t = numCount.get(i);
            while (t > 0) {
                res[pos++] = i;
                t--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 1};
        int[] arr2 = new int[]{2, 2};
        Solution solution = new Solution();
        int[] res = solution.intersect(arr1, arr2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
