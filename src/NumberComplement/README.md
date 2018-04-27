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

显然,使用字符串表示其二进制是最简单清楚的,但不是效率最高的,效率最高的方法还是位操作.

下面这个解法:

```Java
class Solution {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
}
```

Java的Integer模块提供了一个很好的API highestOneBit.其作用如下:

```
   5  -----> 101 ------> ((Integer.highestOneBit(5) = 100) << 1 == 1000) - 1 = 111; 101 ^ 111 = 010 == 2.
十进制      二进制
```

所以就明白了整个过程.

原来的数字: 5

二进制表示 101

5的掩码: 111 通过 Integer.highestOneBit(5) -> 100 << 1 -> 1000 - 1 -> 111 [binary representation]

101 ^ 111 -> 010 == 2.

完毕.

求掩码的这个过程应该牢记,因为很多位操作都用到了掩码.所以应该掌握求掩码.

