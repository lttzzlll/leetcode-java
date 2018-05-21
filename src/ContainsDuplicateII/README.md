### [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/description/)


利用Map存储数字和其索引,下次遇到相同的元素时判断当前元素的索引和Map中相同元素的索引
差值是否不大于k.

代码:

```Java
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i]) && dict.get(nums[i]) + k >= i) return true;
            else dict.put(nums[i], i);
        }
        return false;
    }
}
```