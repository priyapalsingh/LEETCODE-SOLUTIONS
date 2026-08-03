class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        return solve(m-1,n-1,dp);
     }
     private int solve(int r,int c,int[][] dp){
        if(r==0 || c==0){
            return 1;
        }
        if(r<0 || c<0){
            return 0;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int up=solve(r-1,c,dp);
        int left=solve(r,c-1,dp);

        return dp[r][c]=up+left;
     }
}