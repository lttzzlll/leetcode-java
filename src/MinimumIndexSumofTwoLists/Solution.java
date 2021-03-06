package MinimumIndexSumofTwoLists;

import java.util.*;

/**
 * Created by liutaotao on 2017/11/8.
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if (map.containsKey(s)) {
                int dist = map.get(s) + i;
//                System.out.println(s + "(" + map.get(s) + ", " + i + ") => " + dist);
                counter.put(s, dist);
            }
        }
        List<Map.Entry<String, Integer>> cntList = new ArrayList<>(counter.entrySet());
        cntList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int minDist = cntList.get(0).getValue(), idx = 1;
        while (idx < cntList.size()) {
            if (cntList.get(idx).getValue() > minDist) break;
            idx++;
        }
        String[] res = new String[idx];
        for (int i = 0; i < idx; i++) {
            res[i] = cntList.get(i).getKey();
        }
        return res;
    }


    public static void main(String[] args) {
        String[] str1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
//        String[] str1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] str2 = new String[]{"KFC", "Shogun", "Burger King"};
        Solution solution = new Solution();

        String[] res = solution.findRestaurant(str1, str2);
        for (String item : res) {
            System.out.println(item);
        }
    }
}
