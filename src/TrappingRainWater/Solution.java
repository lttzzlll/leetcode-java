package TrappingRainWater;

/**
 * Created by liutaotao on 2017/8/18.
 */
public class Solution {

    public void disp(int[] arr) {
        for (int i : arr) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
    }

    public int[] min(int[] a, int[] b) {
        if (a.length != b.length) {
            return null;
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = min(a[i], b[i]);
        }
        return res;
    }

    public int[] sub(int[] a, int[] b) {
        if (a.length != b.length) {
            return null;
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i] - b[i];
        }
        return res;
    }
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int length = height.length;
        int[] left_most = new int[length];
        int[] right_most = new int[length];
        int curMax = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > curMax) {
                curMax = height[i];
            }
            left_most[i] = curMax;
        }
        curMax = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (height[i] > curMax) {
                curMax = height[i];
            }
            right_most[i] = curMax;
        }
        disp(left_most);
        disp(right_most);
        disp(min(left_most, right_most));
        disp(sub(min(left_most, right_most), height));
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += max(0, min(left_most[i], right_most[i]) - height[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        int res = solution.trap(height);
        System.out.println(res);
    }
}
