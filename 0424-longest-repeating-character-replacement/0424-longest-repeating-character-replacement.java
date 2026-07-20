class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLength = 0;
        int maxCount = 0; // Frequency of the most frequent character in the current window
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            
            // Keep track of maximum frequency of any single character in the window
            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            // Current window length is (right - left + 1)
            // If characters to replace > k, shrink window from left
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum valid length found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}