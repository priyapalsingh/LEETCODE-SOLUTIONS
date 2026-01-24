class Solution {
    public boolean canPartition(int[] nums) {
        int arrsum = 0;
        for (int x : nums) {
            arrsum += x;
        }

        if (arrsum % 2 != 0) return false;

        int n = nums.length;
        int target = arrsum / 2;

        // dp[index][remaining] : can we make 'remaining' using elements 0..index
        Boolean[][] dp = new Boolean[n][target + 1];

        return memoize(n - 1, target, nums, dp);
    }

    private boolean memoize(int index, int remaining, int[] nums, Boolean[][] dp) {
        // sum bana liya
        if (remaining == 0) return true;

        // elements khatam ho gaye ya sum negative ho gaya
        if (index < 0 || remaining < 0) {
            return false;
        }

        if (dp[index][remaining] != null) {
            return dp[index][remaining];
        }

        // pick current element
        boolean pick = memoize(index - 1, remaining - nums[index], nums, dp);

        // not pick current element
        boolean not_pick = memoize(index - 1, remaining, nums, dp);

        dp[index][remaining] = pick || not_pick;
        return dp[index][remaining];
    }
}
