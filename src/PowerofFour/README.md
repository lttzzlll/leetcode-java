### [Power of Four](https://leetcode.com/problems/power-of-four/description/)

一种简单但是不符合题意的方法:

```Java
class Solution {
    public boolean isPowerOfFour(int num) {
        HashSet<Integer> set = new HashSet<>();
        int i = 1;
        while (i < Integer.MAX_VALUE && i > 0) {
            set.add(i);
            i <<= 2;
        }
        return set.contains(num);
    }
}
```