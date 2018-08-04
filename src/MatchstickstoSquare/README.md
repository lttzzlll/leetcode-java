### [Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/description/)

通常情况下,搜索用来求有无解;动态规划用来求最优解.
深搜和广搜也可以用来求最优解.

```Java
class Solution {
    boolean dfs(HashSet<Integer> used, int[] nums, int pos, int sum, int leftSides, int target) {
        if (leftSides == 0) return true;
        if (sum == target) return dfs(used, nums, 0, 0, leftSides - 1, target);
        for (int i = pos; i < nums.length; i++) {
            if (used.contains(i)) continue;
            if (nums[i] + sum > target) continue;
            used.add(i);
            if (dfs(used, nums, i + 1, sum + nums[i], leftSides, target)) return true;
            used.remove(i);
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 4 != 0) return false;
        return dfs(new HashSet<>(nums.length), nums, 0, 0, 4, sum / 4);
    }
}
```

其中,pos的意义是深搜过程中父节点的位置(上一个添加入当前集合的元素在数组nums中的位置),
for循环的意义是深搜的过程中,可以选择的当前结点的集合.其中集合中的某些元素在已经被用过了(成为了父节点),
所以需要一个集合用来标记当前深搜过程中已经被用过的元素.

深搜的基本套路就是维护一个当前搜索的集合A,深搜的过程就是不断地往集合中添加元素的过程.
其中添加的元素来自指定的集合B,深搜的过程中,每次添加元素都是从指定的集合B中选取的,所以需要
记录当前深搜过程中哪些元素被用过的,那些没有被用过,还可以使用,这个集合称为C.因为深搜有多种不同的路径,所以
维护的已使用的集合C只记录当前搜索路径中使用过的元素,深搜是有回溯的,当回溯到路径的上一个节点的时候,就需要把
当前元素e移除已使用集合C.
