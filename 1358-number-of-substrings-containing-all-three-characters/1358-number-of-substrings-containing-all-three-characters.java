class Solution {
    public int numberOfSubstrings(String s) {
        // 'a', 'b', aur 'c' ke frequencies track karne ke liye array
        int[] count = new int[3];
        int left = 0;
        int ans = 0;
        int n = s.length();
        
        for (int right = 0; right < n; right++) {
            // Current character ki frequency badhao
            count[s.charAt(right) - 'a']++;
            
            // Jab tak window mein teeno characters ('a', 'b', 'c') kam se kam ek baar hain
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Agar index 'right' tak teeno mil gaye, toh iske aage ke saare 
                // substrings (n - right) bhi valid honge!
                ans += (n - right);
                
                // Window ko chota karne ke liye left pointer ko aage badhao
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return ans;
    }
}