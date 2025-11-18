class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1 || s==null){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int oddlen=expandfromcenter(s,i,i);
            int evenlen=expandfromcenter(s,i,i+1);
            int maxlen=Math.max(oddlen,evenlen);

            if(maxlen>end-start){
                start=i-(maxlen-1)/2;
                end=i+maxlen/2;
            }
        }
        return s.substring(start,end+1);         
    }
    private int expandfromcenter(String s,int start,int end){
         while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}