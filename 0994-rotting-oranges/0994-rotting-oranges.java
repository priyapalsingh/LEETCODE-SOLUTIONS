class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        // Count fresh + add ALL rotten to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});  // ✅ Position add karo, not value
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0) return 0;  // No fresh oranges
        
        int minutes = 0;
        
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            minutes++;  // Each level = 1 minute
            
            for (int i = 0; i < size; i++) {
                int[] rottenloc = q.poll();
                int r = rottenloc[0];
                int c = rottenloc[1];
                
                // 4 neighbours
                int[][] neighbours = {{r - 1, c}, {r, c - 1}, {r + 1, c}, {r, c + 1}};
                
                for (int[] neighbour : neighbours) {
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    
                    // Bounds check
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {  // ✅ m,n swap fix
                        continue;
                    }
                    
                    // Fresh orange mile to rot karo
                    if (grid[nr][nc] == 1) {  // ✅ Only fresh rot
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});  // New rotten add
                    }
                }
            }
        }
        
        return fresh == 0 ? minutes : -1;  // Complete ? minutes : impossible
    }
}
