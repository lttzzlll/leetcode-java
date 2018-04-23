### [Power of Three](https://leetcode.com/problems/power-of-three/description/)

虽然是最简单的方法,但是不符合题意.

代码:

```Java
class Solution {
   public boolean isPowerOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        int i = 3;
        while (i < Integer.MAX_VALUE && i > 0) {
            set.add(i);
            i *= 3;
        }
        return set.contains(n);
    }
}
```

既不让使用迭代,也不让使用递归,那应该用什么方法?

