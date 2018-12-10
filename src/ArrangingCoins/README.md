### [Arranging Coins](https://leetcode.com/problems/arranging-coins/)

> 水题。简单地总结一下规律很快就有答案。注意的细节是累加的时候可以如果用int可能会溢出，所以需要用long类型来存储累加的结果。


```Java
class Solution {
    public int arrangeCoins(int n) {
        long res = 0;
        int i = 0;
        while (res + (i + 1) <= n) {
            i += 1;
            res += i;
        }
        return i;
    }
}
```
