### [Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/)

动态规划小水题.

代码:

```Java
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] > maxLen) maxLen = dp[i];
            } else dp[i] = 1;
        }
        return maxLen;
    }
}
```

还可以有更加简单的方法,去掉一维数组.但最重要的是状态转移方程.

```
dp[0] = 1;
dp[i] = dp[i-1] + 1 if nums[i] > nums[i-1] else 1, i > 0.
```

最道题最主要的就是简单,前后两个元素之间的关系很简单,所以状态转移方程很容易得出.
