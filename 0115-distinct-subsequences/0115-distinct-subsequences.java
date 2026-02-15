class Solution {
    // Function to count distinct subsequences
    public int numDistinct(String s, String t) {
        // Get lengths of both strings
        int n = s.length();
        int m = t.length();

        // Create dp table of size (n+1) x (m+1)
        long[][] dp = new long[n + 1][m + 1];

        // Base case: empty t can be formed from any suffix of s
        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }

        // Fill dp table from bottom to top
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // If characters match, we have two options:
                // 1. Take this character -> dp[i+1][j+1]
                // 2. Skip this character -> dp[i+1][j]
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    // If characters don't match, we can only skip
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        // Final answer is stored at dp[0][0]
        return (int) dp[0][0];
    }
}