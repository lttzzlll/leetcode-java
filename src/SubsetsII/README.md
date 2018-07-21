### [Subsets II](https://leetcode.com/problems/subsets-ii/description/)

> 在原来的基础上加一个判重的功能.

```Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                ArrayList<Integer> arr = new ArrayList<>(list.get(j));
                arr.add(nums[i]);
                String str = Arrays.toString(arr.toArray());
                if (set.contains(str)) continue;
                list.add(arr);
                set.add(str);
            }
        }
        return list;
    }
}
```

暂时还没有想出来不需要set就可以完成判重功能.
如果再生成子集的过程中就可以避免重复的元素被加入才是最好的.