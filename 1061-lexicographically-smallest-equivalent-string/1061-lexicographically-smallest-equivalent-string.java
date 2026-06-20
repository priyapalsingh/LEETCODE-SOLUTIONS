class Solution {
    // DSU ka parent array track karne ke liye (26 lowercase English letters)
    int[] parent;

    // Find function: Group ka ultimate representative dhoondne ke liye (with Path Compression)
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    // Union function: Do characters ke groups ko merge karne ke liye
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        // Agar dono alag groups me hain, toh merge karo
        if (rootI != rootJ) {
            // Hamesha chote character wale root ko parent banao
            if (rootI < rootJ) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        
        // Initially, har character khud ka parent hai
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Step 1: s1 aur s2 ke characters ke beech me union operation chalao
        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            union(u, v);
        }

        // Step 2: baseStr ke har character ko uske group ke sabse chote character se replace karo
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int curr = baseStr.charAt(i) - 'a';
            int smallestEquivalent = find(curr); // Sabse chota root milega
            sb.append((char) (smallestEquivalent + 'a'));
        }

        return sb.toString();
    }
}