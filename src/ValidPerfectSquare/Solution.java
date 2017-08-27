package ValidPerfectSquare;

/**
 * Created by liutaotao on 2017/8/25.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int pivot = num / 2 + 1;
        for (int i = 1; i <= pivot; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 14;
        Solution solution = new Solution();
        boolean res = solution.isPerfectSquare(a);
        System.out.println(res);
    }
}
