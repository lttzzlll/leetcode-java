package MergeSortedArray;

/**
 * Created by liutaotao on 2017/8/28.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[end--] = nums2[j--];
            } else {
                nums1[end--] = nums1[i--];
            }
        }

        if (i < 0) {
            while (j >= 0) {
                nums1[end--] = nums2[j--];
            }
        }
    }


    public static void main(String[] args) {
//        int[] a = new int[10];
//        a[0] = 0;
//        a[1] = 1;
//        a[2] = 2;
//        a[3] = 8;
//        a[4] = 9;
//        int[] b = new int[5];
//        b[0] = 3;
//        b[1] = 4;
//        b[2] = 5;
//        b[3] = 6;
//        b[4] = 7;
        int[] a = new int[2];
        a[0] = 0;
        int[] b = new int[1];
        b[0] = 1;
        Solution solution = new Solution();
        solution.merge(a, 0, b, 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
