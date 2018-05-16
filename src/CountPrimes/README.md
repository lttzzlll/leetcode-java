### [Count Primes](https://leetcode.com/problems/count-primes/description/)

简单的素数筛选法.

假设数组中所有的元素都是素数,然后不断迭代,找出所有的非素数.

代码:

```Java
class Solution {
    // 素数筛选法
    public int countPrimes(int n) {
        if (n == 0) return 0;
        int cnt = 0;
        int endpoint = (int) Math.sqrt(n) + 1;
        // 默认所有的数都是素数,然后从中筛选出非素数
        boolean[] noPrimes = new boolean[n + 1];
        noPrimes[0] = true;
        noPrimes[1] = true;
        for (int i = 2; i <= endpoint; i++) {
            int j = 2;
            while (true) {
                if (i * j >= n) break;
                noPrimes[i * j] = true;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!noPrimes[i]) {
                cnt++;
//                System.out.println(i);
            }
        }
        return cnt;
    }
}
```

还可以继续优化,但是基本的思路是这样的.
