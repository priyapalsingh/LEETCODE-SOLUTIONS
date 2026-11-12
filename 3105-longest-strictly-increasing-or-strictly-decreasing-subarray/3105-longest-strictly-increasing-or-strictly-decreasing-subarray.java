class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int incLen = 1;
        int decLen = 1;
        int maxLen = 1;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                incLen++;
                decLen = 1; // reset decreasing streak
            } else if (nums[i + 1] < nums[i]) {
                decLen++;
                incLen = 1; // reset increasing streak
            } else {
                incLen = 1;
                decLen = 1;
            }
            
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }
        
        return maxLen;
    }
}