### [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/description/)

水题

每次一动一步或两步,相当于每次都有两个可以搜索的方向:当前位置和下一个位置,
也就是说在每一个搜索的节点上都有两中选择:选择第一个节点或者第二个节点.
然后从这两中选择中找出求和之后最小的一条路径.很容易实现.代码如下:

```Java
class Solution {
    int[] memo = new int[1001];
    private int f(int[] cost, int index) {
        if (memo[index] != 0) return memo[index];
        if (index == cost.length) return 0;
        if (index + 1 == cost.length) return 0;
        memo[index] = Math.min(cost[index] + f(cost, index + 1),
                cost[index + 1] + f(cost, index + 2));
        return memo[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        return f(cost, 0);
    }
}
```

其中,memo数组用于记录已访问过的节点.