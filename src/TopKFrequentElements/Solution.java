package TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liutaotao on 2017/9/13.
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        int[] arr = new int[]{4, 1, -1, 2, -1, 2, 3};
        Solution solution = new Solution();
        List<Integer> res = solution.topKFrequent(arr, 2);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
