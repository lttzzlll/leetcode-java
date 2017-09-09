package BestTimetoBuyandSellStock;

/**
 * Created by liutaotao on 2017/9/7.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else if (prices[i] > min) res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(arr));
    }
}
