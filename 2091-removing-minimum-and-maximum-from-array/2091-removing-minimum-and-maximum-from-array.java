class Solution{
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>nums[max])
            {
                max=i;
            }
            if(nums[i]<nums[min])
            {
                min=i;
            }
        }
        if(max<min)
        {
            int temp=min;
            min=max;
            max=temp;
        }
        return Math.min(max + 1, Math.min(n - min, (min + 1) + (n - max)));
      //return  Math.min((n-max)+(max-min),Math.min(max+1,(n-max)+(min+1)));
    }
}