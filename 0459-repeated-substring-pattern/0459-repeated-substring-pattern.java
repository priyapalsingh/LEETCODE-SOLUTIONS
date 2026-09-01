class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Pehla aur aakhri char drop karke check karo
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}