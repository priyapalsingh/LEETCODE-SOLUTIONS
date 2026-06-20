class Solution {
    public int largestAltitude(int[] gain) {
       int n=gain.length;
       int[] dist=new int[n];
       dist[0]=gain[0];
       for(int i=1;i<n;i++){
        dist[i]=dist[i-1]+gain[i];
       }
       Arrays.sort(dist);
       return dist[n-1]>0?dist[n-1]:0;
    }
}