class Solution {
    private Boolean[][][] memo;
    private int rows, cols;

    public boolean hasValidPath(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        // Path ki total length = (rows + cols - 1)
        // Valid bracket string ki length hamesha EVEN hoti hai. Agar ODD ho toh seedha false.
        if ((rows + cols - 1) % 2 != 0) {
            return false;
        }

        // Maximum possible open brackets (rows + cols) se zyada nahi ho sakte
        memo = new Boolean[rows][cols][rows + cols];

        return solve(grid, 0, 0, 0);
    }

    private boolean solve(char[][] grid, int r, int c, int count) {
        // Grid boundary cross ho jaye
        if (r >= rows || c >= cols) {
            return false;
        }

        // Bracket balance update
        if (grid[r][c] == '(') {
            count++;
        } else {
            count--;
        }

        // Agar closing brackets opening se zyada ho jayein toh path invalid hai
        if (count < 0) {
            return false;
        }

        // Memoization check
        if (memo[r][c][count] != null) {
            return memo[r][c][count];
        }

        // Destination cell par pohench gaye
        if (r == rows - 1 && c == cols - 1) {
            return count == 0; // Final balance exactly 0 hona chahiye
        }

        // Down jaao ya Right jaao
        boolean down = solve(grid, r + 1, c, count);
        boolean right = solve(grid, r, c + 1, count);

        // Result store karke return karo
        return memo[r][c][count] = down || right;
    }
}