class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoize(amount,coins,n-1,dp);
    }
    private int memoize(int amount,int[] coins,int i,int[][]dp){
        if(i==0)  return (amount % coins[0] == 0) ? 1 : 0;
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int notPick=memoize(amount,coins,i-1,dp);
        int pick=0;
        if(coins[i]<=amount){
           pick= memoize(amount-coins[i],coins,i,dp);//infinite coins supply
        }
        return dp[i][amount]= pick+notPick;
    }
}