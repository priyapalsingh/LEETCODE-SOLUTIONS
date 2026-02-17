//question ki condition hai ki kisi bhi stock ko aap buy krrhe ho to next stock buy krne se pehle apko purana wala sell krna pdega 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return getprofit(prices, 0, 0, dp);
    }
    
    private int getprofit(int[] prices, int i, int buy, int[][] dp) {
        int n = prices.length;
        if (i == n) {
            return 0;
        }
        if (dp[i][buy] != -1) return dp[i][buy];
        
        int profit;
        if (buy == 0) {  // Not holding stock
            profit = Math.max(
                getprofit(prices, i + 1, 0, dp),  // Skip
                -prices[i] + getprofit(prices, i + 1, 1, dp)  // Buy
            );
        } else {  // Holding stock
            profit = Math.max(
                getprofit(prices, i + 1, 1, dp),  // Skip
                prices[i] + getprofit(prices, i + 1, 0, dp)  // Sell
            );
        }
        dp[i][buy] = profit;
        return profit;
    }
}
