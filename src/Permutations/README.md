### [Permutations](https://leetcode.com/problems/permutations/description/)
> 一道很基础的利用回溯解决的问题.
```Java
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, 0, res);
        return res;
    }

    /**
     * 1 2 3
     * 1 3 2
     * 2 1 3
     * 2 3 1
     * 3 1 2
     * 3 2 1
     */

    private void perm(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            perm(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

```

> Swap用来交换不同位置的两个元素,正是通过交换这种手段,使得同一位置上可以占有不同的元素;

> 然后还要还原回交换之前的序列,所以在执行以下一个元素为开始的Perm序列之后,再执行一次交换操作.

时间复杂度的分析

| n | O(n) |
| :-----: | :-----: |
| 1 | 1 |
| 2 | 2 * O(1) = 2 * 1 = 2 |
| 3 | 3 * O(2) = 3 * 2 = 6 |
| 4 | 4 * O(3) = 4 * 6 = 24 |
| ... | ... |

O(N) = N * O(N-1)

空间复杂度:
O(1)