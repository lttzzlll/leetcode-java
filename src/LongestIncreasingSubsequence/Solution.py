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
        dp = [1] * length
        for i in range(1, len(nums)):
            lst = [dp[j] + 1 for j in range(i) if nums[i] > nums[j]]
            if lst:
                dp[i] = max(lst)

        return max(dp)


if __name__ == '__main__':
    import doctest
    doctest.testmod()
