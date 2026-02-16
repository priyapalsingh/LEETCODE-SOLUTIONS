//RECURSION SOLUTION

class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        return  min( word1, word2, m,n,dp);
        
    }
    private int min(String word1,String word2,int i,int j,int[][] dp){
        if(i==0) return j;
        if(j==0) return i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(word1.charAt(i-1)==word2.charAt(j-1)){
            return min(word1,word2,i-1,j-1,dp);
        }
        else{
            //deletion
            int delete= 1+min(word1,word2,i-1,j,dp);
            //insert
            int insert=1+min(word1,word2,i,j-1,dp);
            //replace
            int replace=1+min(word1,word2,i-1,j-1,dp);

             dp[i][j]= Math.min(delete ,Math.min(insert,replace));
             
        }
        return dp[i][j];
       
    }

}