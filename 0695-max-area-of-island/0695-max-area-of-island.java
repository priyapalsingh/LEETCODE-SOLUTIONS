class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visited) {
        // Boundary conditions aur visited / water check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
                || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;

        // 1 (current cell) + 4 directions ka area
        return 1 + dfs(r + 1, c, grid, visited)
                 + dfs(r - 1, c, grid, visited)
                 + dfs(r, c + 1, grid, visited)
                 + dfs(r, c - 1, grid, visited);
    }
}