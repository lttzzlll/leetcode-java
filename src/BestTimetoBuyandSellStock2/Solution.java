package BestTimetoBuyandSellStock2;

/**
 * Created by liutaotao on 2017/9/7.
 */
public class Solution {
//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) return 0;
//        int res = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i + 1] > prices[i]) res += prices[i + 1] - prices[i];
//        }
//        return res;
//    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] dp = new int[prices.length]; // what's the meaning of dp?
        int minPrice = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]); // get current min price from prices[i] or minPrice
            if (prices[i] - minPrice >= dp[i - 1]) dp[i] = prices[i] - minPrice;
            else {
                minPrice = prices[i];
                res += dp[i - 1];
            }
        }
        return res + dp[prices.length - 1];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(arr));
    }
}
