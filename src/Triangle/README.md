### [Triangle](https://leetcode.com/problems/triangle/description/)


数字三角形 动态规划入门题.开始接触状态转移方程的第一题.

```
dp(i,j) = triangle(i,j) + min(dp(i+1,j),dp(i+1,j+1)
dp(length-1,j) = triangle(length-1,j) j in (0, triangle(length-1).size())
```

状态转移方程式最重要的,同时要注意边界问题.

代码:

```Java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new LinkedList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new LinkedList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.get(i).add(0);
            }
        }
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    dp.get(i).set(j, triangle.get(i).get(j));
                } else {
                    int t = Math.min(dp.get(i + 1).get(j), dp.get(i + 1).get(j + 1));
                    dp.get(i).set(j, triangle.get(i).get(j) + t);
                }
            }
        }
        return dp.get(0).get(0);
    }
}
```
