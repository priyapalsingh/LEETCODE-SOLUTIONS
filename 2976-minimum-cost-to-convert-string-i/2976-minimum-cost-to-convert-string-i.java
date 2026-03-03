class Solution {
    public long minimumCost(String source, String target, char[] original, 
                           char[] changed, int[] cost) {
        // 26x26 distance matrix (a-z)
         int INF = Integer.MAX_VALUE / 2;
        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;  // Self cost = 0
        }
        
        // Fill direct edges
        int m = original.length;
        for (int i = 0; i < m; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            dist[x][y] = Math.min(dist[x][y], cost[i]);
        }
        
        // Floyd-Warshall: All pairs shortest paths
        for (int mid = 0; mid < 26; mid++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][mid] < INF && dist[mid][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], 
                                        dist[i][mid] + dist[mid][j]);
                    }
                }
            }
        }
        
        // Calculate total cost source → target
        long totalCost = 0;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            
            if (dist[s][t] >= INF) return -1;  // Impossible
            totalCost += dist[s][t];
        }
        
        return totalCost;
    }
}

