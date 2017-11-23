### [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/description/)
> 只要看懂了[Combination Sum](https://leetcode.com/problems/combination-sum/description/)这道题就很容易理解了,只需要注意判重的问题,这里关于判重,应该有更好的方法.
> 关键在于如何让序列是有序的.
> 为了避免重复序列的出现,就是要避免在同一位置上有相同元素被使用,因为候选序列是排序的,所以如果要在同一位置上使用相同的元素,则有 nums[i] == nums[i-1]成立,同时 i > firstPosition
> 所以才有下面的代码
```
    private void solve(List<List<Integer>> res, List<Integer> cur, int[] nums, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        } else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip same element in one position
                cur.add(nums[i]);
                solve(res, cur, nums, i + 1, target - nums[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
```

> 仔细体会.