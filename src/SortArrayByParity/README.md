### [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)

> 水了一题，用到了元素的交换及数组的遍历。

```Java
class Solution {
    private static void swap(int[] A, int low, int high) {
        int temp = A[low];
        A[low] = A[high];
        A[high] = temp;
    }

    public int[] sortArrayByParity(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            while (low < high && (A[low] & 1) == 0)
                low++;

            while (low < high && (A[high] & 1) == 1)
                high--;

            if (low < high) {
                swap(A, low, high);
                low++;
                high--;
            }
        }
        return A;
    }
}
```