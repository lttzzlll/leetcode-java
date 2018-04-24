### [Number Complement](https://leetcode.com/problems/number-complement/description/)

一种比较naive的方法,完全按照题意及Java现有的库的帮助.

```Java
class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        String res = "";
        for (char c : bin.toCharArray()) {
            if (c == '0') res += '1';
            else res += '0';
        }
        return Integer.valueOf(res, 2);
    }
}
```

但这肯定不是考察点.所以考察点是什么?
