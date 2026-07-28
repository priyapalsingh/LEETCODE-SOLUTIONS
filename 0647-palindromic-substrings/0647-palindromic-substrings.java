class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(isPalindrome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isPalindrome(String t){
        int left=0;
        int right=t.length()-1;
        while(left<=right){
            if(t.charAt(left)!=t.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}