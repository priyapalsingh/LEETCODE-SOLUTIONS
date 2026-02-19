class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree=new int[n];
        for(int[] edge:roads){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Arrays.sort(degree);
        long res=0;
        long node=1;
        for(int i=0;i<n;i++){
            res+=node*degree[i];
            node++;
        }
        return res;
        
    }
}