class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;

        int totalPoison = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            // Do attacks ke beech ka time difference
            int diff = timeSeries[i + 1] - timeSeries[i];
            
            // Agar difference duration se chhota hai toh diff add hoga, nahi toh full duration
            totalPoison += Math.min(diff, duration);
        }

        // Aakhri attack ka full duration add karo
        totalPoison += duration;

        return totalPoison;
    }
}