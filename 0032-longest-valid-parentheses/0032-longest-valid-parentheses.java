class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0; // Base case for empty or single char strings

        int[] dp = new int[n];
        int maxlen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // Case 1: "()" pattern
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // Case 2: "))" pattern
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }
}