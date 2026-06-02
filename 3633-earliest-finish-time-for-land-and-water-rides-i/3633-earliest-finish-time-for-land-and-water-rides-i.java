class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landDuration.length;
        int m = waterDuration.length;
        int minTime = Integer.MAX_VALUE;
        
        // Har ek Land ride (i) aur har ek Water ride (j) ka pair check karenge
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // --- Case 1: Land Ride pehle, fir Water Ride ---
                int landFinish1 = landStartTime[i] + landDuration[i];
                // Water ride tabhi shuru hogi jab land ride khatam ho ya water ride open ho (jo bhi bada ho)
                int waterStart1 = Math.max(landFinish1, waterStartTime[j]);
                int totalTime1 = waterStart1 + waterDuration[j];
                
                // --- Case 2: Water Ride pehle, fir Land Ride ---
                int waterFinish2 = waterStartTime[j] + waterDuration[j];
                // Land ride tabhi shuru hogi jab water ride khatam ho ya land ride open ho
                int landStart2 = Math.max(waterFinish2, landStartTime[i]);
                int totalTime2 = landStart2 + landDuration[i];
                
                // Dono cases mein se jo sabse chota (earliest) time de, use minTime mein store karo
                int currentBest = Math.min(totalTime1, totalTime2);
                minTime = Math.min(minTime, currentBest);
            }
        }
        
        return minTime;
    }
}