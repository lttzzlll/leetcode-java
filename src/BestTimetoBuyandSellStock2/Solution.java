package BestTimetoBuyandSellStock2;

/**
 * Created by liutaotao on 2017/9/7.
 */
public class Solution {


    public int maxProfit(int[] prices) {
        int[] sum = new int[prices.length];
        int res = prices[0]; sum[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <)
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(arr));
    }
}
