### [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)

水题

可以使用搜索解决.

if n == 1, return 1.
if n == 2, return 2.
if n > 2:
    此时搜索的方向有两个,向1搜索和向2搜索.
    所以, return f(n - 1) + f(n - 2)


可得如下代码:

```Java
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
```

但是这样做会超时,用一个表记录中间结果,不再重复计算.

```Java
class Solution {
    int[] dp = new int[1000];
    public int climbStairs(int n) {
        if (dp[n] != 0) return dp[n];
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
            return dp[n];
        }
    }
}
```

设置为1000本体就能AC.

看一下代码的结构,打印一下前1-10的结果:

```
1  1
2  2
3  3
4  5
5  8
6  13
7  21
8  34
9  55
10  89
```

显示这是斐波那契数列的变形.

由此可得如下代码:

```Java
class Solution {
    public int climbStairs(int n) {
        if (n  == 1) return 1;
        if (n == 2) return 2;
        int res = 0, a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
```