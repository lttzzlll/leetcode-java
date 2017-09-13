package TopKFrequentElements;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2017/9/13.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        Solution solution = new Solution();
        List<Integer> res = solution.topKFrequent(arr, 2);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
