package _0121;

public class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        // 0 表示当天持有， 1 表示当天不持有
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }
}
