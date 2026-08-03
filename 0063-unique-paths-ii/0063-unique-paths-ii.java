class Solution {
    // Function to solve the problem using tabulation
     public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;    
        int n = matrix[0].length;

        int[][] dp=new int[m+1][n+1];
       for(int[] rows:dp){
        Arrays.fill(rows,-1);
       }
       return func(m-1,n-1,matrix,dp);
     }
    private int func(int r, int c, int[][] matrix, int[][] dp) {
        
        if(r<0 || c<0 || matrix[r][c]==1) {
            return 0;
        }
        if(r==0 && c==0){
            return 1;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int up=func(r-1,c,matrix,dp);
        int left=func(r,c-1,matrix,dp);

        return dp[r][c]=up+left;       
    }
}

