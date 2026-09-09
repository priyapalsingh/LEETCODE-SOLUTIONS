import java.util.*;

class Solution {
    // Function to calculate minimum path sum
    public int minPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Create DP table
        int[][] dp = new int[n][m];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        return helper(matrix,dp,n-1,m-1);
    }
    public int helper(int[][] matrix,int[][] dp,int i,int j){
        if(i==0 && j==0){
            return matrix[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE/2;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=matrix[i][j]+helper(matrix,dp,i-1,j);
        int left=matrix[i][j]+helper(matrix,dp,i,j-1);

        return dp[i][j]=Math.min(up,left);

    }
}

