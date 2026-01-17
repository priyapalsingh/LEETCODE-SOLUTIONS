class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        return dfs(graph,visited,source,destination);
        
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited,int node,int destination){
        if(node==destination) return true;
        if(visited[node]) return false;

        visited[node] = true;
        for(int neighbour :graph.get(node)){
           if(dfs(graph,visited,neighbour,destination)){
            return true;
           }
        }
        return false;
    }
}