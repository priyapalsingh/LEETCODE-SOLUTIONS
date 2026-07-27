class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int i=nums.length-1;
        int j=nums.length-2;
        ans=(nums[i]-1)*(nums[j]-1);
        return ans;
    }
}