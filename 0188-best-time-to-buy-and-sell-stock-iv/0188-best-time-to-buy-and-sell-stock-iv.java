class Solution {
    public int maxProfit(int limit,int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][limit+1];
        int profit=0; 
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=limit;k++){
                    if(j==0){
                        dp[i][j][k]=Math.max(0+dp[i+1][0][k] , -prices[i]+dp[i+1][1][k]);
                    }else{
                        dp[i][j][k]=Math.max(0+dp[i+1][1][k] , +prices[i]+dp[i+1][0][k-1]);
                    }
                    
                }
            }
        }
        return dp[0][0][limit];
        
    }
}