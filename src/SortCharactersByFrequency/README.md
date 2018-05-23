### [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/description/)

对Java的数据结构又熟悉了一边啊.如果用Python是多么的简单啊.


```Java
class Solution {
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
}
```

```Python
from collections import Counter
class Solution:
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = []
        cnter = Counter(s)
        for (c, n) in cnter.most_common():
            res.append(c * n)
        return ''.join(res)
```

这就是为什么要用Python的原因之一.