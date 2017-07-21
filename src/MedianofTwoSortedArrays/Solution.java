package MedianofTwoSortedArrays;

/**
 * Created by 10609 on 2017/7/21.
 */
public class Solution {
    private double findKth(int[] a, int l1, int s1, int[] b, int l2, int s2, int k) {
        if (s1 > s2) {
            return findKth(b, l2, s2, a, l1, s1, k);
        }
        if (s1 == 0) {
            return b[l2 + (k - 1)];
        }
        if (k == 1) {
            return Math.min(a[l1], b[l2]);
        }
        int pa = Math.min(k / 2, s1), pb = k - pa;
        if (a[l1 + (pa - 1)] < b[l2 + (pb - 1)]) {
            return findKth(a, l1 + pa, s1 - pa, b, l2, s2, k - pa);
        } else if (a[l1 + (pa - 1)] > b[l2 + (pb - 1)]) {
            return findKth(a, l1, s1, b, l2 + pb, s2 - pb, k - pb);
        } else {
            return a[l1 + (pa - 1)];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        if (count % 2 == 1) {
            return findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, count / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, count / 2)
                    + findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, count / 2 + 1)) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 7, 9};
        int[] nums2 = new int[]{2, 4, 6, 8, 10};
        Solution solution = new Solution();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
