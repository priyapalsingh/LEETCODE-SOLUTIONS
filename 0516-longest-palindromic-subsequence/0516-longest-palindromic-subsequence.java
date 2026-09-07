import java.util.Arrays;

class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] memo = new int[n][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return lcs(0, 0, s, t, memo);
    }

    private int lcs(int i, int j, String s, String t, int[][] memo) {
        // Base case: jab koi bhi string khatam ho jaye
        if (i == s.length() || j == t.length()) {
            return 0;
        }

        // Return cached result
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Match case
        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = 1 + lcs(i + 1, j + 1, s, t, memo);
        } 
        // Mismatch case: ek baar s ka character skip, ek baar t ka skip
        else {
            int skipS = lcs(i + 1, j, s, t, memo);
            int skipT = lcs(i, j + 1, s, t, memo);
            memo[i][j] = Math.max(skipS, skipT);
        }

        return memo[i][j];
    }
}