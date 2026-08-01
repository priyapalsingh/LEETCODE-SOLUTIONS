import java.util.Arrays;

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        
        // dp[i][j] : -1 (unvisited), 0 (false), 1 (true)
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int count = 0;

        // Har possible substring range [i, j] check karo
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(i, j, s, dp) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private int solve(int i, int j, String s, int[][] dp) {
        // Base Case 1: Single character is always a palindrome
        if (i >= j) {
            return 1;
        }

        // DP Memoization Check
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Outer characters same hone par inner substring (i+1, j-1) check karo
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i + 1, j - 1, s, dp);
        }

        return dp[i][j] = 0;
    }
}