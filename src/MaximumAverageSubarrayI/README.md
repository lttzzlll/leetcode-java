### [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/description/)

动态规划的一个简单的问题.


Naive的代码会超时:

```Java
class Solution {
    double avg(int[] nums, int low, int high) {
        double res = 0;
        for (int i = low; i < high; i++) {
            res += nums[i];
        }
        return res / (high - low);
    }

    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i + k <= nums.length; i++) {
            double t = avg(nums, i, i + k);
            if (t > max) max = t;
        }
        return max;
    }
}
```

因为有一部分结果(k-1个元素的结果)已经得出,不必在计算.所以优化就出在如何减小重复的计算量.
所以,从题目出发,减少计算量的地方就在于每次遍历到一个新的元素的时候,就把该元素和当前最小序列
的第一个元素比较,如果不大于当前序列的第一个元素,显然,后k-1个元素与该新遍历元素之和也不会大于
当前序列之和.根据这一发现,得到下面代码.总体来说,还是很简单的.


```Java
class Solution {
    double avg(int[] nums, int low, int high) {
        double res = 0;
        for (int i = low; i < high; i++) {
            res += nums[i];
        }
        return res / (high - low);
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0;
        double max = avg(nums, 0, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] <= nums[i - k]) continue;
            double t = avg(nums, i - k + 1, i + 1);
            if (t > max) max = t;
        }
        return max;
    }
}
```