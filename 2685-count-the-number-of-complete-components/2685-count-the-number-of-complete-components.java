class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int completeComponents=0;
        boolean[] visited=new boolean[n];
        for(int node=0;node<n;node++){
            if(!visited[node]){
                int[] info=new int[2];
                dfs(graph,visited,node,info);

                 int nodes=info[0];
                 int edgeCount=info[1]/2;

            if(edgeCount==nodes*(nodes-1)/2){
                completeComponents++;
            }

            }
           
        }
        return completeComponents++;

    }
    
private void dfs(List<List<Integer>> graph,boolean[] visited,int node,int[] info){
    visited[node]=true;
    info[0]++;
    info[1]+=graph.get(node).size();

    for(int neighbour:graph.get(node)){
        if(!visited[neighbour]){
            dfs(graph,visited,neighbour,info);
        }
    }
}
}