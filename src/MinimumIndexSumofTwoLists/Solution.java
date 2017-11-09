package MinimumIndexSumofTwoLists;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by liutaotao on 2017/11/8.
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i =0 ; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++ ){
                if (list1[i] == list2[j]) {
                    if (!map.containsKey(list1[i])) {
                        map.put(list1[i], i + j);
                    } else if (map.get(list1[i]) > i + j) {

                    }
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String[] str1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Solution solution = new Solution();

        String[] res = solution.findRestaurant(str1, str2);
        for (String item : res) {
            System.out.println(item);
        }
    }
}
