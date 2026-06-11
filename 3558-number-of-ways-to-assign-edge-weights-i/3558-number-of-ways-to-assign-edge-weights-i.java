import java.util.*;

public class Solution {
    private int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        long MOD = 1000000007;

        // Adjacency list prepare karna
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        maxDepth = 0;
        // DFS run karenge root 1 se start karke (parent = -1, current_depth = 0)
        dfs(1, -1, 0, adj);

        // Agar maxDepth (k) hai, toh edges count k hogi.
        // Hamein calculate karna hai 2^(maxDepth - 1) % MOD
        if (maxDepth == 0) return 0; // Edge case (waise constraints me n >= 2 hai)

        return (int) power(2, maxDepth - 1, MOD);
    }

    private void dfs(int node, int parent, int depth, List<List<Integer>> adj) {
        maxDepth = Math.max(maxDepth, depth);

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, depth + 1, adj);
            }
        }
    }

    // Fast Fourier / Binary Exponentiation to calculate (base^exp) % MOD
    private long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}