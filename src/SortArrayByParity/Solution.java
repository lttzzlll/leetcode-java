package SortArrayByParity;

public class Solution {
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

    public static void print(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[] { 3, 1, 2, 4 };
        print(A);
        Solution s = new Solution();
        int[] B = s.sortArrayByParity(A);
        print(B);
    }
}