class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        //if one string is palindrome then other can be empty ""
        int n=a.length();
        if(isPalindrome(a,0,n-1) || isPalindrome(b,0,n-1)){
            return true;
        }
        //now for cases other than this
       return  validate(a,b) || validate(b,a);       
        
    }
    private boolean validate(String a,String b){
        int i=0;
        int j=a.length()-1;
        while(i < j && a.charAt(i) == b.charAt(j)){
            i++;
            j--;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }
    private boolean isPalindrome(String str,int i,int j){
        //int i=0;
       // int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}