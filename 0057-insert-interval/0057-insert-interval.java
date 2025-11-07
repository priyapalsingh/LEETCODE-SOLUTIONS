class Solution {
    public int[][] insert(int[][] intervals, int[] newinterval) {
        ArrayList<int[]> result=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while(i<n && intervals[i][1]<=newinterval[0]){
            result.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newinterval[1]){
            newinterval[0]=Math.min(intervals[i][0],newinterval[0]);
            newinterval[1]=Math.max(intervals[i][1],newinterval[1]);
            i++;
        }
        result.add(newinterval);
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
        
    }
}