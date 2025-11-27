class Solution {
    public int findbound(int[] nums,int target,boolean findfirst){
        int left=0,right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                if(findfirst){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=findbound(nums,target,true);
        int last=findbound(nums,target,false);
        return new int[]{first,last};
        
        
    }
}