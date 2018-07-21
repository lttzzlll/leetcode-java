### [Subsets](https://leetcode.com/problems/subsets/description/)


```Python
from itertools import combinations, chain
from functools import reduce
from operator import add

class Solution:
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return reduce(add, list(list(combinations(nums, i)) for i in range(len(nums) + 1)))

```

费了九牛二虎之力写的python代码,这要是换成Java,要多少行代码啊!


考察简单的组合问题.在一个集合中,拿或者不拿某个东西,然后形成不同的组合.

```Java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        res.add(arr);
        for (int n : nums) {
            int len = res.size();
            for (int i = 0; i < len; i++) {
                ArrayList<Integer> t = new ArrayList<>(res.get(i));
                t.add(n);
                res.add(t);
            }
        }
        return res;
    }
}
```

这个算法的时间复杂度为O(2^n), 其中n为数组的长度,这个时间复杂度也符合组合的定义.
因为最终获取的集合的数量是O(2^n),所以每次迭代都得到了其中的一个集合.

这个算法才是我想要的,简单,清晰.

生成子集合的过程非常的巧妙.

初始化的时候是一个空集,这个时候没有加入任何给定集合中的元素. no pick
然后依次遍历给定集合中的元素,将该元素加入当前的子集中. pick every element
观察最终结果集合的长度,其长度增加的幅度依次为0, 1, 2, 4, 8, ...
所以最终集合的长度为O(2^n), 其中n为给定数组的长度.