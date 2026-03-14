class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];//0 not colored,1 clr one,-1 clr two
        
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!bfs(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
        
    }
    public boolean bfs(int[][] graph,int start,int[] color){
        Queue<Integer> qu=new LinkedList<>();
        qu.offer(start);
        color[start]=1;

        while(!qu.isEmpty()){
            int node=qu.poll();
            for(int neighbour:graph[node]){
                if(color[neighbour]==0){
                    color[neighbour]=-color[node];
                    qu.offer(neighbour);
                }else if(color[neighbour]==color[node]){
                    return false;
                }
            }
        }
        return true;


    }
}