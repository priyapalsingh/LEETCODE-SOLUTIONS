class Solution {
    int[] parent=new int[26];
    public int findparent(int x){
        if(parent[x]!=x){
            parent[x]=findparent(parent[x]);
        }
        return parent[x];
    }

    public boolean equationsPossible(String[] equations) {
        //initialise the parent array
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        //check for == case
        for(String eq:equations){
            if(eq.charAt(1)=='!') continue;
            int u=eq.charAt(0)-'a';
            int v=eq.charAt(3)-'a';
            union(u,v);
        }
        for(String eq:equations){
            if(eq.charAt(1)=='=') continue;
            int u=eq.charAt(0)-'a';
            int v=eq.charAt(3)-'a';
            if(findparent(u)==findparent(v)){
                return false;
            }
        }
        return true;
        
    }
    private void union(int x, int y) {
        int rootX = findparent(x);
        int rootY = findparent(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}