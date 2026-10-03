class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> allIntervals = new ArrayList<>();
        for(int[] interval:intervals){
            allIntervals.add(interval);
        }
        allIntervals.add(newInterval);
        allIntervals.sort((a,b)-> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current=allIntervals.get(0);
        merged.add(current);

        for(int[] next:allIntervals){
            if(next[0] <= current[1]){
                current[1]=Math.max(current[1],next[1]);
            }else{
                current=next;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}