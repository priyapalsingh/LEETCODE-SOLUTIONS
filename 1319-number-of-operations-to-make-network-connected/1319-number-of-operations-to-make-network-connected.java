class Solution {
    int[] parent;
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int components = n;
        int extraCables = 0;
        
        for (int[] conn : connections) {
            int a = find(conn[0]), b = find(conn[1]);
            if (a != b) {
                parent[a] = b;
                components--;
            } else {
                extraCables++;  // Redundant cable
            }
        }
        
        int needed = components - 1;
        return extraCables >= needed ? needed : -1;
    }
}
