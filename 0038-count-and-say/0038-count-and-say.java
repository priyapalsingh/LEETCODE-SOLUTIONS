class Solution {
    public String countAndSay(int n) {
        // Base case: n = 1 par humesha "1" return karna hai
        if (n == 1) {
            return "1";
        }
        
        // Shuruat humesha "1" se hogi
        String s = "1";
        
        // Hamein n-1 baar RLE process chalana hai
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            
            // Pichli string par loop chalayenge aur characters compare karenge
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    // Agar same character chal raha hai toh ginti badhao
                    count++;
                } else {
                    // Character badal gaya! Purane ka count aur char append karo
                    current.append(count).append(s.charAt(j - 1));
                    count = 1; // Naye character ke liye count reset
                }
            }
            
            // Loop ke baad bache hue aakhri character ko append karna zaroori hai
            current.append(count).append(s.charAt(s.length() - 1));
            
            // Agle round ke liye s ko update kar do
            s = current.toString();
        }
        
        return s;
    }
}