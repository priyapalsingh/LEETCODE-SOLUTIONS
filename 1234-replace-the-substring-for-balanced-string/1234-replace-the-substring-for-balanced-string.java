class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;
        
        // Character frequency array ('Q', 'W', 'E', 'R' ke ASCII for fast lookup)
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        // Base Case: Agar string pehle se balanced hai
        if (count['Q'] <= target && count['W'] <= target && 
            count['E'] <= target && count['R'] <= target) {
            return 0;
        }

        int minLen = n;
        int left = 0;

        // Sliding Window
        for (int right = 0; right < n; right++) {
            // Right character ko window ke andar include kar lo (count kam karo)
            count[s.charAt(right)]--;

            // Jab tak window ke BAHAR wale sabhi characters <= target hain
            while (left < n && count['Q'] <= target && count['W'] <= target && 
                               count['E'] <= target && count['R'] <= target) {
                
                minLen = Math.min(minLen, right - left + 1);
                
                // Left character ko window se bahar nikalo (count wapas badhao)
                count[s.charAt(left)]++;
                left++;
            }
        }

        return minLen;
    }
}