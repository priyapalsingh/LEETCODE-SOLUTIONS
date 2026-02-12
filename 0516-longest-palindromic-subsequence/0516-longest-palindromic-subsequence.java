class Solution {
    public int longestPalindromeSubseq(String s) {
        String t=new StringBuilder(s).reverse().toString();
        return lcs(s,t);
    }
    private int lcs(String s,String t){
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        //base case
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        //fill the rest of the table
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                 if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                // If they don't match, take the max by ignoring one character from either string
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}