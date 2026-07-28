class Solution {
    public String smallestPalindrome(String s) {
       int halflen=s.length()/2;
       int len=s.length();

       int[] freq=new int[26];
       for(int i=0;i<halflen;i++){
        freq[s.charAt(i)-'a']++;
       } 
       StringBuilder firstHalf=new StringBuilder();
       for(int i=0;i<26;i++){
        while(freq[i]>0){
           firstHalf.append((char)('a'+i));
           freq[i]--; 
        }
       }

       String mid="";
       if(len%2 !=0){
        mid=String.valueOf(s.charAt(halflen));
       }

       String secondHalf=new StringBuilder(firstHalf).reverse().toString();

       return firstHalf.toString() + mid + secondHalf;
    }
}