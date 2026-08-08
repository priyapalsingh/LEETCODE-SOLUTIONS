import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // Step 1: Precompute last valid index in word1 for each character in word2
        int[] lastMatchedIndex = new int[m];
        Arrays.fill(lastMatchedIndex, -1);

        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                lastMatchedIndex[j] = i;
                j--;
            }
        }

        // Step 2: Greedily pick smallest indices from left to right
        int[] ans = new int[m];
        j = 0;
        boolean hasChanged = false;

        for (int i = 0; i < n && j < m; i++) {
            boolean isExactMatch = (word1.charAt(i) == word2.charAt(j));

            if (isExactMatch) {
                ans[j++] = i;
            } else if (!hasChanged) {
                // Check if remaining word2 can fit after index i
                boolean canFitRemaining = (j == m - 1) || (lastMatchedIndex[j + 1] > i);

                if (canFitRemaining) {
                    hasChanged = true;
                    ans[j++] = i; // Use 1 allowed change here
                }
            }
        }

        // If we matched all 'm' characters, return the answer array
        return (j == m) ? ans : new int[0];
    }
}