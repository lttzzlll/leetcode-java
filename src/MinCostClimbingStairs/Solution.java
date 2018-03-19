package MinCostClimbingStairs;

/**
 * Created by liutaotao on 2018/3/15.
 */
public class Solution {
    // 1 100 1 1 1 100 1 1 100 1
    // 0 1   2 3 4 5   6 7 8   9
    //
    int[] memo = new int[1001];

    private int f(int[] cost, int index) {
        if (memo[index] != 0) return memo[index];
        if (index == cost.length) return 0;
        if (index + 1 == cost.length) return 0;
        memo[index] = Math.min(cost[index] + f(cost, index + 1),
                cost[index + 1] + f(cost, index + 2));
        return memo[index];
    }

    public int minCostClimbingStairs(int[] cost) {
        return f(cost, 0);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] a = new int[]{0, 0, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(a));
    }
}
