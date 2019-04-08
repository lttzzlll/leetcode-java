package MinimumCostForTickets;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] memo = new int[days.length + 1][days.length + 1];
        for (int i = 0; i < days.length; i++) {
            memo[i][0] = costs[0];
        }
        
        return -1;
    }

    public static void main(String[] arags) {
        int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
        int[] costs = { 2, 7, 15 };
        Solution s = new Solution();
        int cost = s.mincostTickets(days, costs);
        System.out.println(cost);
    }
}