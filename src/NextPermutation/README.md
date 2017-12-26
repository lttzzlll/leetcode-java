### [Next Permutation](https://leetcode.com/problems/next-permutation/description/)

Discuss中给出了清晰易懂的解释,代码很容易理解,但是没有将背后的原理是什么.
下面是给出的解题思路:
1. 从尾到头遍历一下数组,如果nums[i-1] > nums[i]始终成立,说明数组是单减序列,那么要得到该序列的下一个按"字母顺序"的序列,只需将该数组反转一下,很容易实现.
2. 如果nums[i-1] > nums[i]在i-1处不成立,则说明nums[i-1] <= nums[i], 但从i到nums.length-1还是一个递减序列,按照第一步,将序列[i,nums.length-1]反转一下既可以得到按"字母顺序"的序列,
但此时存在一个问题,序列[i, nums.length-1]中是否存在大于nums[i-1]的元素,比如原序列为 4, 6, 9, 7, 5, 3, 1,则nums[i-1]=6,nums[i]=9,序列 9, 7, 5, 3, 1是递减序列,然后将该序列反转一下,得到 4 6 1 3 5 7 9.
此时有 4 6 1 3 5 7 9 为 4 6 9 7 5 3 1 的下一个序列,但这显然是不对的.因为 4 6 1 3 5 7 9 的下一个序列是 4 7 ....,所以只需将6 和 7 交换一下,得到 4 7 9 6 5 3 1,然后反转,得到 4 7 1 3 5 6 9,才是我们真正想要的序列.
3. 即在 i - 1 到 nums.length - 1 中找到一个大于 nums[i-1]的元素 nums[k],然后交换nums[i-1]与nums[k],最后翻转序列[i, nums.length-1],得到正确答案.

理解了这一点,代码就很容易得出.

```Java
class Solution {
    static void swap(int[] num, int i, int j) {
        if (i != j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }


    static void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) break;
            i--;
        }
        if (i > 0) {
            int x = nums.length - 1;
            while (x >= i) {
                if (nums[x] > nums[i - 1]) break;
                x--;
            }
            swap(nums, i - 1, x);
        }
        reverse(nums, i, nums.length - 1);
    }
}
```
