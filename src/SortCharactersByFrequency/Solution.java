package SortCharactersByFrequency;

import java.util.*;

/**
 * Created by liutaotao on 2018/5/23.
 */
public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (Character c : s.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
            list.add(entry);
        }
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Character> cs = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : list) {
            int cnt = entry.getValue();
            Character c = entry.getKey();
            while (cnt > 0) {
                cs.add(c);
                cnt--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : cs) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String str = "cccaaa";
//        String str = "Aabb";
        String str = "raaeaedere";
        Solution solution = new Solution();
        System.out.println(solution.frequencySort(str));
    }
}
