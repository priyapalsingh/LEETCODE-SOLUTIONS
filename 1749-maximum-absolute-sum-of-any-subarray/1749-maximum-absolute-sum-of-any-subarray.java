class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int runningMax=0;
        int maxSum=0;

        int runningMin=0;
        int minSum=0; 
        for(int i=0;i<n;i++){
            runningMax=Math.max(runningMax+nums[i],nums[i]);
            maxSum=Math.max(maxSum,runningMax);

            runningMin=Math.min(runningMin+nums[i],nums[i]);
            minSum=Math.min(minSum,runningMin);
        }
        return Math.max(maxSum,Math.abs(minSum));
    }
}