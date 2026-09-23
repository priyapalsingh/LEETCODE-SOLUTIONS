class Solution {
    public int minOperations(int[] nums, int x) {
        int target=0;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        target=sum-x;
        if(target<0){
            return -1;
        }
        if(target==0){
            return nums.length;
        }
        int left=0;
        int currsum=0;
        int maxlen=-1;

        for(int right=0;right<nums.length;right++){
            currsum+=nums[right];

            while(currsum>target && left<=right){
                currsum-=nums[left];
                left++;
            }

            if(currsum==target){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        return maxlen== -1 ? -1 : nums.length-maxlen;

    }
}