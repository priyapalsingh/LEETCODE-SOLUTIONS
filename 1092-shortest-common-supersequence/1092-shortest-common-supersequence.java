class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        //initialise
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        //fill the dp table
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        int i=m,j=n;
        while(i>0 && j>0){
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans.append(s.charAt(i - 1));
                i--;
                j--;
            }

            // Move in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s.charAt(i - 1));
                i--;
            } else {
                ans.append(t.charAt(j - 1));
                j--;
            }
        }
        //remaining values of s
        while(i>0){
            ans.append(s.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(t.charAt(j-1));
            j--;
        }
         // Reverse the result since it was built backwards
        return ans.reverse().toString();        
    }
}