### [Minimum Index Sum of Two Lists](https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/)


又熟悉了一边Java的数据结构.真的是超级麻烦.


代码:


```Java
import java.util.*;

class Solution {
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
}
```

或许还有更好的方法,但是这是最基本的方法,最常想到的思路.