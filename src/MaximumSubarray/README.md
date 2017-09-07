### [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)
> 简单的动态规划的运用,与该题相似的问题是[Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/).
> 后面那道题的状态明显复杂一点,这道题相对简单.
> 为了保持序列的连续性,在判定的时候,当前元素必须加入判定的序列中,表示的意义是加入该元素后当前序列的最大值.
> 但是这个当前元素也是产生新的断点,重新开始一个序列的地方, 条件就是 nums[i] > sum[i - 1] + nums[i]
> 如果该条件成立,说明当前元素 > 之前序列累积的和, 所以应该从当前元素开始开始一个新的序列.
> 声明一个变量res来记录每个序列产生的最大值,然后返回该最大值.