### [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/)

简单的二分查找的应用.因为题目说数组已经是排序的.而这个问题又是一个查找问题,所以很自然的要用二分查找法.

代码:


```Java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int cnt = 1;
        char lastChar = letters[0];
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == lastChar) continue;
            lastChar = letters[i];
            cnt++;
        }
        char[] ret = new char[cnt];
        ret[0] = letters[0];
        int idx = 0;
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] != ret[idx]) ret[++idx] = letters[i];
        }
        int pos = Arrays.binarySearch(ret, target);

        if (pos < 0) {
            pos = -(pos + 1);
            return ret[pos % cnt];
        } else {
            return ret[(pos + 1) % cnt];
        }
    }
}
```

比较麻烦的一步是数组的去重.
