### [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/description/)
> 动态规划,Bottom-Up,基本的思路已经理解,优化的方法比较费解.
```
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            path[i][0] = path[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            path[0][j] = path[0][j - 1] + grid[0][j];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                path[i][j] = Integer.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];

        return path[m - 1][n - 1];
    }
```

> 既然已经有了自底向上的方案,那么也一定有Up-Bottom的方案,及所谓的递归版本.
```
    private int solve(int[][] grid, int[][] memo, int x, int y) {
        if (x < 0 || y < 0) return 0;

        if (memo[x][y] != 0) return memo[x][y];

        if (x > 0 && y > 0)
            memo[x][y] = Integer.min(
                    solve(grid, memo, x - 1, y),
                    solve(grid, memo, x, y - 1)) + grid[x][y];
        else if (x == 0)
            memo[x][y] = solve(grid, memo, x, y - 1) + grid[x][y];
        else memo[x][y] = solve(grid, memo, x - 1, y) + grid[x][y];

        return memo[x][y];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        return solve(grid, memo, m - 1, n - 1);
    }
```
> 有几点需要想明白:搜索的起点是什么,搜索的终点是什么,搜索的方向是什么.

> Bottom-Up Vs Up-Bottom.

> 既然是Bottom-Up,或者Up-Bottom,那么这里一定指的是搜索的方向.

> 凡是使用迭代的都是Bottom-Up,即搜索的方向从问题的起点到问题的终点.

> 反过来,凡是使用递归的都是Up-buttom,即搜索的方向从问题的终点到问题的起点.

> 因为在递归的过程中可能会重复一些"解空间的状态",所以一般情况下用一张表来记录"已经走过的路",

> 即将已经求解的"最优答案"保存起来,不再重复求解.

> 所以,从递归的角度来看动态规划,就是加了一张额外用来保存"最优解"的表.