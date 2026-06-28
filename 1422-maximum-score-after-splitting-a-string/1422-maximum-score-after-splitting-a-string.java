class Solution {
    public int maxScore(String str) {
        int totalOnes = 0;
        int n = str.length();
        
        // Step 1: Pure string me total 1s kitne hain count kar lo
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }
        
        int maxScore = 0;
        int zerosInLeft = 0;
        int onesInRight = totalOnes;
        
        // Step 2: Split points par iterate karo 
        // Loop n-1 tak chalega taaki right substring non-empty rahe
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == '0') {
                zerosInLeft++;
            } else {
                onesInRight--;
            }
            
            // Current split ka score calculate karo aur max update karo
            int currentScore = zerosInLeft + onesInRight;
            maxScore = Math.max(maxScore, currentScore);
        }
        
        return maxScore;
    }
}