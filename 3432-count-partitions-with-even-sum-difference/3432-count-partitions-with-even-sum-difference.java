class Solution {
    public int countPartitions(int[] nums) {
        int totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        int leftsum=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            leftsum+=i;
            int rightsum=totalsum-leftsum;
            if((leftsum-rightsum)%2==0){
                count++;
            }
        }
        return count;
        
    }
}