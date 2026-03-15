class Solution {
    public int maxSubArray(int[] nums) {
        int currsum=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
             //Either extend the previous subarray or start 
            // new from current element
            currsum=Math.max(currsum+nums[i],nums[i]);
            res=Math.max(currsum,res);
        }
        return res;
        
    }
   
}