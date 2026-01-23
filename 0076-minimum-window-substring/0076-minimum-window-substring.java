class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0) return "";
        
        Map<Character,Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
       // int want = need.size();
       int want=t.length();
        int have = 0;
        
        Map<Character,Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while(right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            if(need.containsKey(c) && window.get(c) <= need.get(c)) {
                have++;
            }
            
            while(have == want && left <= right) {
                int currLen = right - left + 1;  // ← currLen (not currlen)
                
                
                if(currLen < minLen) { 
                    minLen = currLen;
                    minStart = left;
                }
                
                // Remove left
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }
                left++;
            }
            right++;
        }
        
        // ❌ WRONG: s.substring(minStart, minLen)
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);  // ✅ FIXED
    }
}
