class Solution {
    public int alternatingSubarray(int[] nums) {
        int currlen=0;
        int maxlen=-1;

        for(int i=0;i<nums.length;i++){
            int expected_diff=1;
            currlen=1;
            for(int j=i;j<nums.length-1;j++){
                if(nums[j+1]-nums[j]==expected_diff){
                    currlen++;
                    expected_diff=-expected_diff;
                }
                else{
                    break;
                }
            }
            if(currlen>1){
                 maxlen=Math.max(maxlen,currlen);
            }
        }
        return maxlen;
    }
}