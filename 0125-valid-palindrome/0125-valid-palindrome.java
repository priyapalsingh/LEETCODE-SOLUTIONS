class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]",""));
        StringBuilder newsb=new StringBuilder(sb).reverse();
        return sb.toString().equals(newsb.toString());
        
    }
}