### [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/description/)


用一个字典保存每个元素出现的次数,然后再次遍历字符串,第一个元素计数为1的元素的索引就是所求.

代码:

```Java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
```

基本思路就是这样.