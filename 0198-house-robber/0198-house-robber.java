import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Memoization array ko -1 se initialize karte hain
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }

    private int solve(int i, int[] nums, int[] dp) {
        // Base Case: Agar array boundary se bahar nikal gaye
        if (i >= nums.length) {
            return 0;
        }

        // Return memoized result if already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Choice 1: Rob current house and move to i + 2
        int rob = nums[i] + solve(i + 2, nums, dp);

        // Choice 2: Skip current house and move to i + 1
        int skip = solve(i + 1, nums, dp);

        // Store and return max of both choices
        return dp[i] = Math.max(rob, skip);
    }
}