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
                //case 2
                //ye (()) ese ke liye hai ki closing se pehle bhi ek closing tha toh wo check krlo ki wo valid tha to dp mei stored hoga fir dp update krte wqt abji ki valid + pichli valid + agar pichli se pehle bhi ki valid thi toh use bhi add krdo
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }
}