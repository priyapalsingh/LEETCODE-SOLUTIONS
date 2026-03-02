class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[] {v,w});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        dist[k]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[] {k,0});
        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int node=current[0];
            int d=current[1];
            if(d>dist[node]) continue;

            for(int[] nei:adj.get(node)){
                int nextNode=nei[0];
                int weight=nei[1];

                if(dist[nextNode]> dist[node]+weight){
                    dist[nextNode]=dist[node]+weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE / 2) return -1;  // Some unreachable
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
        
    }
}