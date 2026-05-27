class Solution {
    public int numberOfSpecialChars(String word) {
        // Arrays ko -1 se initialize karenge taaki pata chale kaunsa char nahi aaya
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        java.util.Arrays.fill(lastLower, -1);
        java.util.Arrays.fill(firstUpper, -1);
        
        // Ek hi pass mein saare indices store karenge
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i; // Update karte rahenge taaki LAST index mile
            } else {
                int idx = ch - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i; // Sirf pehli baar FIRST index store karenge
                }
            }
        }
        
        int count = 0;
        
        // Ab check karenge ki condition satisfy ho rahi hai ya nahi
        for (int i = 0; i < 26; i++) {
            // 1. Lowercase present hona chahiye (lastLower[i] != -1)
            // 2. Uppercase present hona chahiye (firstUpper[i] != -1)
            // 3. Last lowercase, first uppercase se pehle aana chahiye
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        
        return count;
    }
}