class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> set=new HashSet<>();
       for(String word:wordDict){
        set.add(word);
       } 
       Boolean[] dp=new Boolean[s.length()+1];

       return solve(0,s,set,dp);
    }
    private boolean solve(int start,String s,Set<String> set,Boolean[] dp){
        //base case
        if(start==s.length()){
            return true;
        }
        if(dp[start]!=null){
            return dp[start];
        }
        for(int end=start+1;end<=s.length();end++){
            String prefix=s.substring(start,end);

            if(set.contains(prefix) && solve(end,s,set,dp)){
                return dp[start]=true;
            }
        }
        return dp[start]=false;

    }
}