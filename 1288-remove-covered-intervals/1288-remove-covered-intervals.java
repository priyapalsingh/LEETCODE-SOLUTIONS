import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = intervals.length;
        
        // 1. Sort: Start points in ascending. If start points are equal, End points in descending.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Descending for end points
            }
            return Integer.compare(a[0], b[0]);     // Ascending for start points
        });
        
        int maxEnd = 0; // Ab tak ka sabse bada right bound track karega
        
        // 2. Iterate through sorted intervals
        for (int i = 0; i < intervals.length; i++) {
            // Agar current interval ka end point maxEnd ke andar hai, toh yeh covered hai
            if (intervals[i][1] <= maxEnd) {
                count--; 
            } else {
                // Nahi toh, is naye aur bade end point ko maxEnd bana lo
                maxEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}