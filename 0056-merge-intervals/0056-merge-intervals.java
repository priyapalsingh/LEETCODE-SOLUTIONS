import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd < nextStart) {
                // No overlap, add the current interval to result
                mergedIntervals.add(new int[] {currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            } else {
                // Overlap found, merge intervals by extending the end if needed
                currentEnd = Math.max(currentEnd, nextEnd);
            }
        }

        // Add the last interval
        mergedIntervals.add(new int[] {currentStart, currentEnd});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
