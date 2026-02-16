class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        //create dp 
         int[][] dp = new int[m+1][n+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return stringmatch(s,p,m-1,n-1,dp);        
    }
    private boolean isallstars(String s,int i){
            for (int j = 0; j <= i; j++) {
            if (s.charAt(j) != '*')
                return false;
            }
            return true;
        }
    private boolean stringmatch(String s,String p,int i,int j,int[][] dp){
        //base case
        
        //if s and p both get exhausted
        if(i<0 && j<0){
            return true;
        }
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0) return isallstars(p,j);

        if (dp[i][j] != -1) return dp[i][j] == 1;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            dp[i][j]=stringmatch(s,p,i-1,j-1,dp)?1:0;
        }
        else if(p.charAt(j)=='*'){
            dp[i][j]=(stringmatch(s,p,i-1,j,dp) || stringmatch(s,p,i,j-1,dp)) ? 1:0;
        }
        else{
            dp[i][j]=0;
        }
        return dp[i][j]==1;
    }
}