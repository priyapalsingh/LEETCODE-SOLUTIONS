class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        return solve(0,n-1,piles,dp)>0;

    }
    private int solve(int i,int j,int[] piles,int[][] dp){
        if(i==j) return i;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int pickleft=piles[i]+solve(i+1,j,piles,dp);
        int pickright=piles[j]+solve(i,j-1,piles,dp);

        return dp[i][j]=Math.max(pickleft,pickright);
    }
}