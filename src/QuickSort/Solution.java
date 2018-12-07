package QuickSort;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Solution {

    void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    int partation(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin;
        for (int j = begin; j <= end - 1; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i += 1;
            }
        }
        swap(array, i, end);
        return i;
    }

    int partation2(int[] array, int begin, int end) {
        int pivot = array[begin];
        int i = begin + 1, j = end;
        while (i <= j) {
            while (i <= j && array[i] <= pivot) i++;
            while (i <= j && pivot < array[j]) j--;
            if (i < j) {
                swap(array, i, j);
                i++;
                i--;
            }
        }
        if (j <= i) {
            swap(array, begin, j);
        }
        return j;
    }

    int QSelect(int[] array, int begin, int end, int k) {
        int pivot = partation(array, begin, end);
        if (k < pivot) {
            return QSelect(array, begin, pivot - 1, k);
        } else if (k > pivot) {
            return QSelect(array, pivot + 1, end, k);
        } else {
            return array[pivot];
        }
    }

    int QuickSelect(int[] array, int k) {
        return QSelect(array, 0, array.length - 1, k - 1);
    }

    void Qsort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int pivot = partation2(array, begin, end);
        Qsort(array, begin, pivot - 1);
        Qsort(array, pivot + 1, end);
    }

    void QuickSort(int[] array) {
        Qsort(array, 0, array.length - 1);
    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d\t", i);
        }
        System.out.println();
    }

    static void printArray(int[] array, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.printf("%4d\t", array[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        printArray(array);

        int[] arr0 = Arrays.copyOf(array, array.length);
        int[] arr1 = Arrays.copyOf(array, array.length);
        int[] arr2 = Arrays.copyOf(array, array.length);
        Arrays.sort(arr0);
        printArray(arr0);
        System.out.println("====================================");


        Solution s = new Solution();
        s.QuickSort(arr1);
        printArray(arr1);

        int k = 5;
        int e = s.QuickSelect(arr2, k);
        System.out.println(e);
        System.out.println(arr0[k - 1]);
        String str = "hello";
        Integer i;
        HashMap<Integer, Integer> res = null;
    }

}
