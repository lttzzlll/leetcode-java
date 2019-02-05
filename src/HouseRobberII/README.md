### [House Robber II](https://leetcode.com/problems/house-robber-ii/)

[House Robber](https://leetcode.com/problems/house-robber/)的升级版，比之前多了一个限制条件。从这个角度来看，根据这个限制条件，构造满足限制条件的解即可。状态转移方程没有变，唯一的变化就是起止终点变了，从之前的唯一一个变成了两个，并且取其中比较之后的最大值。

```java
public int rob(int[] nums) {
    if (nums.length == 0)
        return 0;
    else if (nums.length == 1)
        return nums[0];
    else if (nums.length == 2)
        return Integer.max(nums[0], nums[1]);
    int maxlen = 0;
    int length = nums.length;
    int[] dp = new int[length];
    dp[0] = nums[0];
    dp[1] = Integer.max(dp[0], nums[1]);
    for (int i = 2; i < length - 1; i++) {
        dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    maxlen = dp[length - 2];
    dp[0] = 0;
    dp[1] = nums[1];
    dp[2] = Integer.max(dp[1], nums[2]);
    for (int i = 3; i < length; i++) {
        dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    maxlen = Integer.max(maxlen, dp[length - 1]);
    return maxlen;
}
```
