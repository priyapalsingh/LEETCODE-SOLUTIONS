class Solution {
    public int mirrorDistance(int n) {
       int original=n;
       int rem=0;
       while(n!=0){
        int dig=n%10;
       rem=rem*10+dig;
       n/=10;
       }
       return Math.abs(original-rem);
       
    }
}