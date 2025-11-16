class Solution {
    public int numSub(String s) {
        int n=s.length();
        long count=0,result=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                count++;
                result+=count;
                result%=mod;
            }
            else{
                count=0;
            }
        }
        return (int) result;
        
    }
}