import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        
        // 1. Original score array ko clone aur sort karo
        int[] arr = score.clone();
        Arrays.sort(arr); // Ascending order mein sort hoga (sabse chhota pehle, sabse bada last mein)

        // 2. HashMap banao jo Score -> Rank/Medal map karega
        Map<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rank = n - i; // Ascending order ki wajah se last element (n-1) rank 1 hoga
            
            if (rank == 1) {
                rankMap.put(arr[i], "Gold Medal");
            } else if (rank == 2) {
                rankMap.put(arr[i], "Silver Medal");
            } else if (rank == 3) {
                rankMap.put(arr[i], "Bronze Medal");
            } else {
                rankMap.put(arr[i], String.valueOf(rank));
            }
        }

        // 3. Original array ke order ke according output array fill karo
        for (int i = 0; i < n; i++) {
            ans[i] = rankMap.get(score[i]);
        }

        return ans;
    }
}