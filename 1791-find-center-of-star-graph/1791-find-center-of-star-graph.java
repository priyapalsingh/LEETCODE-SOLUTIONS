class Solution {
    public int findCenter(int[][] edges) {
        int totaledges=edges.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<totaledges;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);
            if(map.get(u)==totaledges) return u;
            if(map.get(v)==totaledges) return v;
        }
        return -1;
        
    }
}