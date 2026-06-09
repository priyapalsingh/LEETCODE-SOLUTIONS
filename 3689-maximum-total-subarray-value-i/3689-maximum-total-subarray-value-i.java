class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        int diff=nums[nums.length-1]-nums[0];
        return (long)diff*k;
    }
}