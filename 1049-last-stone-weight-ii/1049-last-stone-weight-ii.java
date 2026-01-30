class Solution {
    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int sum = 0;

        for (int x : stones) sum += x;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // sum = 0 always possible
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (stones[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int half = sum / 2;
        int s1 = 0;

        for (int j = half; j >= 0; j--) {
            if (dp[n][j]) {
                s1 = j;
                break;
            }
        }

        return sum - 2 * s1;
    }
}
