class Solution {
    // Changed return type from long to int
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Option 1: Land ride then Water ride
        long plan1 = getEarliestFinish(landStartTime, landDuration, waterStartTime, waterDuration);
        
        // Option 2: Water ride then Land ride
        long plan2 = getEarliestFinish(waterStartTime, waterDuration, landStartTime, landDuration);
        
        // Explicitly cast the final minimum result to int
        return (int) Math.min(plan1, plan2);
    }
    
    private long getEarliestFinish(int[] startTime1, int[] duration1, int[] startTime2, int[] duration2) {
        long minFirstEnd = Long.MAX_VALUE;
        
        // Find the absolute earliest we could possibly finish the first ride
        for (int i = 0; i < startTime1.length; i++) {
            minFirstEnd = Math.min(minFirstEnd, (long) startTime1[i] + duration1[i]);
        }
        
        long ans = Long.MAX_VALUE;
        
        // Find the best time to complete the second ride based on the minimum finish of the first
        for (int i = 0; i < startTime2.length; i++) {
            long finishTime = Math.max(minFirstEnd, startTime2[i]) + duration2[i];
            ans = Math.min(ans, finishTime);
        }
        
        return ans;
    }
}
