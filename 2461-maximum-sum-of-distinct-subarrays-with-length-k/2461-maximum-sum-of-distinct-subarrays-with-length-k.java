class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long currsum=0;
        long maxsum=0;
       Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            currsum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==k){
            maxsum=currsum;
        }
        
        for(int i=k;i<n;i++){
            currsum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            int outel=nums[i-k];
            currsum-=outel;
            if(map.get(outel)==1){
                map.remove(outel);
            }else{
                map.put(outel,map.get(outel)-1);
            }
            if(map.size()==k){
                maxsum=Math.max(maxsum,currsum);
            }
        }
        return maxsum;
    }
}