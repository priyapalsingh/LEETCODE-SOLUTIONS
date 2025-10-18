class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        
        for(int x:nums){
            totalsum +=x;
        }
        int leftsum=0;
        for(int i=0;i<n;i++){
            
            if(leftsum*2==totalsum-nums[i]){
                return i;
            }
            leftsum +=nums[i];
        }
        return -1;
    }
}