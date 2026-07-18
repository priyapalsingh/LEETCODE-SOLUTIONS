class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int largest=nums[nums.length-1];
        int smallest=nums[0];
        if(largest%smallest==0){
            return smallest;
        }
        for(int i=smallest-1;i>=0;i--){
            if(smallest%i==0 && largest%i==0){
                return i;
            }
        }
        return 1;
    }
}