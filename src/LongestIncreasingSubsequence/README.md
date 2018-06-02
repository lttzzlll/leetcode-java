### [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/)


考察动态规划.动态规划的三个特征.

* 重叠子问题
* 最优子结构
* 无后效性

代码:

```Java
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) len = Math.max(len, dp[j] + 1);
            }
            dp[i] = len;
        }
        int maxLen = 0;
        for (int i: dp) {
            if (i > maxLen) maxLen = i;
        }
        return maxLen;
    }
}
```

这个代码时间复杂度虽然是O(n*2), 但是基本思路就是这样.还有一种版本就是始终维护一个单调递增的序列,
如果有大于该序列最大值(该序列中最后一个元素)的元素,则将其加入该序列,否则,找个这个元素在该序列中
排序的位置,替换掉原来的元素.最终该序列的长度就是原序列中 **最大单调递增子序列** 的长度.其中,查找
元素位置的方法用二分查找法,因为维护的序列是有序的.

代码:

```Java
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] seq = new int[nums.length];
        int seqLen = 0;
        seq[seqLen++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq[seqLen - 1]) seq[seqLen++] = nums[i];
            else {
                int idx = Arrays.binarySearch(seq, 0, seqLen, nums[i]);
                if (idx < 0) idx = -(idx + 1);
                seq[idx] = nums[i];
            }
        }
        return seqLen;
    }
}
```

二分查找法速度更快.关键在于维护了一个 **单调递增子序列** , 然后所有的查询操作都在该序列上进行,
由于该序列数有序的,所以可以用二分查找法查找,所以时间复杂度为 O(log(2, n) * n). 其中 n 为原序列的长度.
需要从头到尾遍历原序列,时间复杂度为O(n). 在遍历到每个元素的时候,都要查询一下 维护的 **单调递增子序列** 中当前元素
的位置,查询的时间复杂度为 O(log(2, n)). 总的时间复杂度为 O(log(2, n)) * O(n) = O(log(2, n) * n).

上面, 维护的 **单调递增子序列** , 当当前元素大于该序列中的最大元素时,将当前元素加入该序列,很好理解;
当当前元素不大于该序列中的最大元素时,就在该序列中找到一个合适的位置,用当前元素替换掉原来的元素.这样并不改变
 **单调递增子序列** 的长度, 序列中各个元素的相对位置也不会改变,仅仅受影响的是被替换掉的元素.因为当前元素和
 被替换掉的元素在 **单调递增子序列** 中的相对位置是一样的,所以就被替换掉了.这个被替换的动作是有意义的,因为
 后续的元素在比较的时候需要和当前元素进行比较,只有在大于当前元素的时候才有可能加入这个 **单调递增子序列** .


第一种思路的Python代码,更加的贴合想要表达的东西.

```Python
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
```
 
第二种思路,维护一个 **单调递增子序列** , 然后用二分查找法查找当前元素在该序列中的位置.


```Python
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

```
