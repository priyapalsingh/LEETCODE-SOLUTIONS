class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(0,-1,adj,hasApple);
        
    }
    private int dfs(int src,int parent,List<List<Integer>> adj,List<Boolean> hasApple){
        int time=0;
        for(int neighbour:adj.get(src)){
            if(neighbour==parent) continue;
            int timetakenbychild=dfs(neighbour,src,adj,hasApple);
            if(timetakenbychild>0 || hasApple.get(neighbour)){
                time+=timetakenbychild+2;
            }
        }
        return time;
    }
}