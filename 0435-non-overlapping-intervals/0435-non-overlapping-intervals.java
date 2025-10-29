

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
       
        int intervalsToRemove = 0;
        
        // 'prev' pointer: Index of the last selected non-overlapping interval
        int prev = 0; 
        
        // 'curr' pointer: Index of the current interval being examined
        // Start from the second interval (index 1)
        for (int curr = 1; curr < intervals.length; curr++) {
            
            if (intervals[curr][0] >= intervals[prev][1]) {
                
                prev = curr;
            } else {
                
                intervalsToRemove++;
                
                //  We do NOT update 'prev' here. 'prev' still points to the earlier-finishing 
                // interval which we have chosen to KEEP.
            }
        }

        return intervalsToRemove;
    }
}