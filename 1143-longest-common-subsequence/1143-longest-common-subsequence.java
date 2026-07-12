class Solution {
    Integer[][] memo; 
    public int longestCommonSubsequence(String s, String t) {
        memo=new Integer[s.length()][t.length()];
        int res=lcs(s,t,0,0);
        return res;    
    }
    private int lcs(String s, String t,int i,int j){
        if(i==s.length() || j==t.length()){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            memo[i][j]=1+lcs(s,t,i+1,j+1);
        }else{
            int skipi=lcs(s,t,i+1,j);
            int skipj=lcs(s,t,i,j+1);
            memo[i][j]=Math.max(skipi,skipj);
        }
        return memo[i][j];


    }
}