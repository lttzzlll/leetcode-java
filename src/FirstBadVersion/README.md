### [First Bad Version](https://leetcode.com/problems/first-bad-version/description/)
> 二分法求解,边界需要考虑一下,这个问题中(left+right)存在溢出的问题,需要注意.
> (left + right) / 2 ==> left + (right - left) / 2.