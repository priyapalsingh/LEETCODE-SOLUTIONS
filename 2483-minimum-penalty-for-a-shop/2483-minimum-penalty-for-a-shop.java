class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pref = new int[n + 1];   // pref[i] = #Y in [0..i-1]

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int totalY = pref[n];
        int bestHour = 0;
        int minPenalty = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            int yBefore = pref[j];
            int nBefore = j - yBefore;          // open but no customer
            int yAfter = totalY - yBefore;      // closed but customer
            int penalty = nBefore + yAfter;     // j - 2*yBefore + totalY

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
    }
}
