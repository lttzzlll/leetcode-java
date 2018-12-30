package Bag;

public class Solution {
    private int maxW = Integer.MIN_VALUE;
    private int[] weight = { 2, 2, 4, 6, 3 };
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];

    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW)
                maxW = cw;
            return;
        }
        if (mem[i][cw])
            return;
        mem[i][cw] = true;
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.f(0, 0);
        System.out.println(solution.maxW);
    }
}