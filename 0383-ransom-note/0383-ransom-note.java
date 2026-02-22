class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        
        // Magazine ke chars count karo
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        
        // Ransom note ke chars check karo
        for (char ch : ransomNote.toCharArray()) {
            if (count[ch - 'a'] == 0) return false;
            count[ch - 'a']--;
        }
        
        return true;
    }
}
