class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];
        
        int diff = game(0, stoneValue, dp);
        
        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }

    private int game(int i, int[] stoneValue, Integer[] dp) {
        int n = stoneValue.length;
        if (i >= n) return 0; // Base case: koi stone bacha hi nahi
        
        if (dp[i] != null) return dp[i];

        int maxDiff = Integer.MIN_VALUE;
        int currentTake = 0;

        // Current player 1, 2, ya 3 stones le sakta hai
        for (int k = 0; k < 3 && i + k < n; k++) {
            currentTake += stoneValue[i + k];
            // Next turn me opponent ka score subtract hoga
            int outcome = currentTake - game(i + k + 1, stoneValue, dp);
            maxDiff = Math.max(maxDiff, outcome);
        }

        return dp[i] = maxDiff;
    }
}