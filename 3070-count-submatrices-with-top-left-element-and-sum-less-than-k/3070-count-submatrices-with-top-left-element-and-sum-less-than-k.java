class Solution {
    public int countSubmatrices(int[][] grid, int k) {  // ← int, not long
        int m = grid.length, n = grid[0].length;
        long[][] prefix = new long[m+1][n+1];  // prefix stays long
        int count = 0;  // ← int accumulator
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + grid[i-1][j-1];
                if (prefix[i][j] <= k) count++;  // auto-converts long→int safely
            }
        }
        return count;  // ← safe within int range per constraints
    }
}
