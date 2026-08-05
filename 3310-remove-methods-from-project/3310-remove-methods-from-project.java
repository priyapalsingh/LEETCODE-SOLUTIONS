import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Adjacency List Graph Construct Karo
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            graph.get(inv[0]).add(inv[1]);
        }

        // Step 2: DFS se k se Reachable (Suspicious) Nodes Mark Karo
        boolean[] isSuspicious = new boolean[n];
        dfs(k, graph, isSuspicious);

        // Step 3: Check karo agar koi Outside Node kisi Suspicious Node ko invoke kar raha hai
        boolean canRemove = true;
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
            // Outside node u invokes suspicious node v
            if (!isSuspicious[u] && isSuspicious[v]) {
                canRemove = false;
                break;
            }
        }

        // Step 4: Final Output Construct Karo
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canRemove || !isSuspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] isSuspicious) {
        isSuspicious[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!isSuspicious[neighbor]) {
                dfs(neighbor, graph, isSuspicious);
            }
        }
    }
}