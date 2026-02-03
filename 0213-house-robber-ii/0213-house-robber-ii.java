class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        //case 1
        int ans1=houseroblinear(nums,0,n-2);
        //case 2
        int ans2=houseroblinear(nums,1,n-1);
        return Math.max(ans1,ans2);
        
    }
    private int houseroblinear(int[] nums,int s,int e){
        int prev1=0,prev2=0;
        for(int i=s;i<=e;i++){
            int temp=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}