class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int totalSubarrays = 0;

        // Check every possible starting point of a subarray
        for (int i = 0; i < n; i++) {
            int targetCount = 0;
            int otherCount = 0;

            // Expand the subarray to the right
            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    targetCount++;
                } else {
                    otherCount++;
                }

                // If target appears strictly more than half the times
                if (targetCount > otherCount) {
                    totalSubarrays++;
                }
            }
        }

        return totalSubarrays;
    }
}