class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        int maxside=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    maxside=Math.max(maxside,solve(i,j,matrix,dp));
                }
            }
        }
        return maxside*maxside;
    }
    private int solve(int i,int j,char[][] matrix,int[][] dp){
        int m=matrix.length;
        int n=matrix[0].length;

        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j]=='0'){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int right=solve(i,j+1,matrix,dp);
        int down=solve(i+1,j,matrix,dp);
        int diagonal=solve(i+1,j+1,matrix,dp);

        return dp[i][j]=1+Math.min(right,Math.min(down,diagonal));
    }
}