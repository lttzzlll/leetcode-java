### [Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/description/)
> Discuss中有很好的解释，原理还是之前方案。   
> 用 -nums[position] 来标记 position+1是重复的，但是不会覆盖 nums[position]原来的值，因为通过Math.abs(nums[position])又还原之前的值。  