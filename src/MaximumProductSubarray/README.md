### [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)
> 这道题用到了动态规划,Discuss中的方法非常巧妙.
> [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)这道题是该题目的一个简化版本,
> 看明白了这个简化的版本,这道题也就大概明白了, 与简化版本的不同之处在于,简化版本是累计求和,这道题是累计求积.
> 累计求和像是一个单连通电路,而这道题则是一个双联通的电路, 需要同时记录当前序列的最大值和最小值,
> 因为不知道下一个元素是正数还是负数,所以当前序列的累积最大乘积和累积最小最小乘积均有可能产生最大值.
> 所以要同时求解当前序列的最导致和最小值. 其余的思路和简化版本相同.