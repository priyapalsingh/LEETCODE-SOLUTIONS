class Solution {
    public boolean validPalindrome(String s) {
        int n=s.length();
        return checkifpalindrome(s,0,n-1,false);
        
    }
    public boolean checkifpalindrome(String s,int left,int right,boolean deleted){
        if(s.charAt(left)==s.charAt(right)){
            left++;
            right--;
        }
        else{
            if(deleted) return false;
            return checkifpalindrome(s,left+1,right,true) || checkifpalindrome(s,left,right-1,true);
        }
        return true;
    }
}