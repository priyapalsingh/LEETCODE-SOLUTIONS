class Solution {
    int[] parent;
    int[] size;

    public int findparent(int x){
        if(parent[x]!=x){
            parent[x]=findparent(parent[x]);
        }
        return parent[x];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        size=new int[n+1];
         for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;  // Each node initial size = 1
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int rootu=findparent(u);
            int rootv=findparent(v);

            if(rootu==rootv){
                return edge;//already in same component that means cyclic edge
            }
             if (size[rootu] < size[rootv]) {
                parent[rootu] = rootv;
                size[rootv] += size[rootu];
            } else {
                parent[rootv] = rootu;
                size[rootu] += size[rootv];
            }
        }
        return new  int[]{};
    }
}