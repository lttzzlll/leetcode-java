### [Permutations II](https://leetcode.com/problems/permutations-ii/description/)

按照 [Permutations](https://leetcode.com/problems/permutations/description/)的思路,只需要加上一步判重就好了.

```Java
    private HashSet<String> set = new HashSet<>();

    private String arrToString(int[] nums) {
        StringBuilder sb = new StringBuilder(nums.length);
        for (int i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void perm(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            String str = arrToString(nums);
            if (!set.contains(str)) {
                set.add(str);
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            perm(nums, start + 1, res);
            swap(nums, i, start);
        }
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, 0, res);
        return res;
    }

```

但这是一种偷懒的想法,有更好的思路,让序列有序,然后在遍历的时候判重.

### Next Permutation
这道题就是在Next Permutation的基础上添加一个过滤器,过滤掉重复的序列.所以理解了Next Permutation就很容易添加这个过滤条件了.
注意Java中的值传递与引用传递,参见王垠的这篇文章[Java 有值类型吗](http://www.yinwang.org/blog-cn/2016/06/08/java-value-type).


无法工作的版本

```
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    private void perm(int[] num, int start, List<List<Integer>> res) {
        if (start == num.length - 1) {
            res.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[start]) continue;
            swap(num, i, start);
            perm(num, start + 1, res);
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        perm(num, 0, res);
        return res;
    }
```

可以工作的版本

```Java
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    private void perm(int[] num, int start, List<List<Integer>> res) {
        if (start == num.length - 1) {
            res.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[start]) continue;
            swap(num, i, start);
            perm(Arrays.copyOf(num, num.length), start + 1, res);
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        perm(num, 0, res);
        return res;
    }
```