class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        
        // Step 1: Count vowels for the very first window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        
        maxVowels = currentVowels; // Initialize max with the first window's count
        
        // Step 2: Slide the window from index k to the end of the string
        for (int i = k; i < s.length(); i++) {
            // Remove the character that is sliding out of the window
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            
            // Add the new character that is sliding into the window
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            
            // Update maxVowels if the current window has more vowels
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        
        return maxVowels;
    }
    
    // Helper function to keep the code clean
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}