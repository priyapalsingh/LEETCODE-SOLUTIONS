class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Cycle sort - Put each number in its right place if possible
        for (int i = 0; i < n; i++) {
            // Check if the current number is in the valid range [1, n]
            // and if it is not already at its correct target index
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at its correct position
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Find the first index where the number doesn't match the index rule
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // This is the first missing positive
            }
        }

        // Step 3: If all positions are correct, then 1 to n are present
        return n + 1;
    }
}