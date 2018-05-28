### [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/description/)


就这个破题,弄了半天.分成三部分和一种特殊情况:

开头,结尾,中间和长度为1的情况.然后针对各种情况编码.

```Java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && i == len - 1 ||
                        i == 0 && i + 1 < len && flowerbed[i + 1] == 0 ||
                        i == len - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0 ||
                        i > 0 && i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    if (--n == 0) return true;
                }
            }
        }
        return false;
    }
}
```
