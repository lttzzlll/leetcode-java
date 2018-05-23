### [Perfect Number](https://leetcode.com/problems/perfect-number/description/)

很简单的一道题,按照题意即可.

代码:

```Java
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1, stop = num;
        for (int i = 2; i < stop; i++) {
            if (num % i == 0) {
                stop = num / i;
                sum += i;
                sum += stop;
            }
        }
        return sum == num;
    }
}
```

其中,降低时间复杂度的方法就是尽量减小上边界,而每次迭代确定两个元素:一个上边界,和一个下边界
都能把上边界减小.比如:

```
n = 28,
i = 1, sum += i + (num / i) if num / i == 0.
i = 2, n / i = 14. 此时的上边界变为14. i 只需遍历到14即可停止.
i = 4, n / i = 7. 此时的上边界是7. i 只需遍历到7即可停止.
```

这样,就大大减小了需要遍历的元素的个数.


Discuss中的方法简单而巧妙,但如何证明?
