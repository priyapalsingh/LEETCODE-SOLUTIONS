class Solution {
     public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix[0].length;    
        int n = matrix.length;       

        // DP table to store results
        int[][] dp = new int[n][m];

        return func(m, n, matrix, dp);
    }
    private int func(int m, int n,int[][] matrix, int[][] dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
               
        }
        return dp[m-1][n-1];

     }
}