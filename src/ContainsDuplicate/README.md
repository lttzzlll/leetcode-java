### [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/)


水题一个

基本上是两种思路,排序和哈希.没什么好讲的.

```Java
import java.util.Arrays;

/**
 * Created by liutaotao on 2018/5/18.
 */
public class Solution {
//    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i : nums) {
//            if (set.contains(i)) return true;
//            else set.add(i);
//        }
//        return false;
//    }

    public boolean containsDuplicate(int[]nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
```