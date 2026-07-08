class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum=0;
        int maxsum=nums[0];
        int minsum=nums[0];
        int currmax=0;
        int currmin=0;
        for(int x:nums){
            currmax=Math.max(currmax+x,x);
            maxsum=Math.max(currmax,maxsum);

            currmin=Math.min(currmin+x,x);
            minsum=Math.min(currmin,minsum);

            totalsum+=x;
        }
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,totalsum-minsum);



    }
}