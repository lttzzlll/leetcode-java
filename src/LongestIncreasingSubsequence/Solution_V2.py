from bisect import bisect_left


class Solution:
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        >>> Solution().lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18])
        4
        """

        length = len(nums)
        if length == 0:
            return 0
        dp = []
        for i in range(0, length):
            if len(dp) == 0:
                dp.append(nums[i])
            else:
                idx = bisect_left(dp, nums[i])
                if idx == len(dp):
                    dp.append(nums[i])
                else:
                    dp[idx] = nums[i]
        return len(dp)


if __name__ == '__main__':
    import doctest
    doctest.testmod()
