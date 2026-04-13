class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length;
        int minDist=Integer.MAX_VALUE;
        int dist;
        
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                dist=Math.abs(i-start);
               minDist=Math.min(dist,minDist);
            }
        }
        return minDist;
       
    }
}