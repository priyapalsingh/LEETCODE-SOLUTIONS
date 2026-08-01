class Solution {
    // Function to count distinct subsequences
    public int numDistinct(String s, String t) {
       int slen=s.length();
       int tlen=t.length();

       int[][] dp=new int[slen][tlen];
       for(int[] rows:dp){
        Arrays.fill(rows,-1);
       }

       return solve(s,t,dp,0,0);
    }
    private int solve(String s, String t,int[][] dp,int i,int j){
        int slen=s.length();
       int tlen=t.length();

        if(j==tlen) return 1;
        if(i==slen) return 0; 

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i)==t.charAt(j)){
            //char match hogya to pick not pick kro 
            dp[i][j]= solve(s,t,dp,i+1,j+1)+solve(s,t,dp,i+1,j);

        }else{
            dp[i][j]= solve(s,t,dp,i+1,j);
        }
          
        return dp[i][j];  
    }
}