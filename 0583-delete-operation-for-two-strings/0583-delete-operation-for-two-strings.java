class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        //create dp table
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minoperation(s1,s2,n,m,dp);              
        
    }
    private int minoperation(String s1, String s2,int i,int j,int[][] dp){
        if(i==0) return j;
        if(j==0) return i;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i-1)==s2.charAt(j-1)){
           return dp[i][j]=  minoperation(s1,s2,i-1,j-1,dp);
        }

        int skipi=minoperation(s1,s2,i-1,j,dp);
        int skipj=minoperation(s1,s2,i,j-1,dp);

        return dp[i][j]=1+Math.min(skipi,skipj);
    }
}