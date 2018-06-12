### [Set Mismatch](https://leetcode.com/problems/set-mismatch/description/)

被这个傻B题侮辱到智商了...

代码:

```Java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        int len = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) ret[0] = nums[i];
            else map.put(nums[i], Boolean.TRUE);
        }
        for (int i = 1; i <= len; i++) {
            if (!map.containsKey(i)) {
                ret[1] = i;
                break;
            }
        }
        return ret;
    }
}
```
