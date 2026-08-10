class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // 1 se n tak saare states build karo
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                // Agar opponent ko losing state me bhej sakte hain
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break; // Ek winning move mil gaya
                }
            }
        }

        return dp[n];
    }
}