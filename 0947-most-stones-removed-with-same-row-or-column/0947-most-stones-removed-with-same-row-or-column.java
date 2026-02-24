class Solution {
    public int removeStones(int[][] stone) {
        int n=stone.length;
        
        //create adjecency list 
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //ha stone ko uske next wale stone se sompare kro ki wo same row ya column mei hai toh
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //add in adjecency list if row or column is same
                if(stone[i][0]==stone[j][0] || stone[i][1]==stone[j][1]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }

            }
        }
        boolean[] visited=new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,adj);
                components++;
            }
        }
        return n-components;
    }
    private void dfs(int node,boolean[] visited,List<List<Integer>> adj){
        visited[node]=true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,adj);
            }
        }
    }
}