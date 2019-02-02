### [House Robber](https://leetcode.com/problems/house-robber/)

1. 简单递归版本
```python
def f(i, nums):
    if i < 0:
        return 0
    return max(f(i - 1, nums), f(i - 2, nums) + nums[i])
```

2. 备忘录模式
```python
memo = {}
def f(i, nums):
    if i < 0:
        return 0
    if i in memo:
        return memo[i]
    memo[i] = max(f(i - 1, nums), f(i - 2, nums) + nums[i])
    return memo[i]
```

3. 表格模式/递推模式
```python
def f(nums):
    length = len(nums)
    if length == 0:
        return 0
    if length < 2:
        return max(nums)
    dp = [0] * length
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for i in range(2, length):
        dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    return dp[-1]
```


```java
public int rob(int[] nums) {
    int length = nums.length;
    if (length == 0)
        return 0;
    else if (length == 1)
        return nums[0];
    else if (length == 2)
        return Integer.max(nums[0], nums[1]);
    int[] dp = new int[length];
    dp[0] = nums[0];
    dp[1] = Integer.max(nums[0], nums[1]);
    for (int i = 2; i < length; i++) {
        dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[length - 1];
}
```

水题一个, 状态转移方程很简单.
