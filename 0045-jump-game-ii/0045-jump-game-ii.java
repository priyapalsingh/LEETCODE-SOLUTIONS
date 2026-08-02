class Solution {
    public int jump(int[] nums) {
        int numlen=nums.length;
        int[] dp=new int[numlen];
        Arrays.fill(dp,-1);

        return solve(0,nums,dp);
    }
    private int solve(int i,int[] nums,int[] dp){
        int numlen=nums.length;
        if(i>=numlen-1){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int minjump=100000;
        int dest=nums[i];
        for(int j=1;j<=dest;j++){
            if(i+j<=numlen-1){
                int ans=1+solve(i+j,nums,dp);
                minjump=Math.min(minjump,ans);
            }
            
        }
        return dp[i]=minjump;
    }
}