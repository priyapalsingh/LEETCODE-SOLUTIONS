class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        // Do alag arrays: ek secret ke liye, ek guess ke liye
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];
        
        // Step 1: Bulls nikal lo aur unmatched digits ko arrays mein daal do
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s == g) {
                // Exact match -> Bull
                bulls++;
            } else {
                // Match nahi hua, toh unki frequency record kar lo
                secretCounts[s - '0']++;
                guessCounts[g - '0']++;
            }
        }
        
        // Step 2: Cows nikalne ke liye dono arrays ko compare karo (0 se 9 tak)
        for (int i = 0; i < 10; i++) {
            // Jo digit dono mein jitni baar common hai, utni Cows banengi
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }
        
        return bulls + "A" + cows + "B";
    }
}