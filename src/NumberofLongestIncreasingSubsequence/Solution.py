class Solution:
    def findNumberOfLIS(self, nums):
        """

        >>> Solution().findNumberOfLIS([1, 3, 6, 7, 9, 4, 10, 5, 6])
        1
        >>> Solution().findNumberOfLIS([1, 2, 4, 3, 5, 4, 7, 2])
        3
        >>> Solution().findNumberOfLIS([2, 2, 2, 2, 2])
        5

        :type nums: List[int]
        :rtype: int
        """

        length = len(nums)
        if length <= 1:
            return length

        nums_length = [1] * length
        nums_count = [1] * length

        for i in range(1, length):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    if nums_length[j] + 1 > nums_length[i]:
                        nums_length[i] = nums_length[j] + 1
                        nums_count[i] = nums_count[j]
                    elif nums_length[j] + 1 == nums_length[i]:
                        nums_count[i] += nums_count[j]

        max_length = max(nums_length)
        max_count = sum(nums_count[i] for i in range(length) if nums_length[i] == max_length)
        return max_count


if __name__ == '__main__':
    import doctest
    doctest.testmod()
