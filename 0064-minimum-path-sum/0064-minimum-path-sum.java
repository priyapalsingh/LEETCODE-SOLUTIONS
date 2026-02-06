import java.util.*;

class Solution {
    // Function to calculate minimum path sum
    public int minPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Create DP table
        int[][] dp = new int[n][m];

        // Fill the table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // First cell initialization
                if (i == 0 && j == 0)
                    dp[i][j] = matrix[i][j];
                else {
                    // Calculate from top
                    int up = matrix[i][j];
                    if (i > 0) up += dp[i - 1][j];
                    else up += (int)1e9;

                    // Calculate from left
                    int left = matrix[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left += (int)1e9;

                    // Take minimum
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        // Return result
        return dp[n - 1][m - 1];
    }
}

