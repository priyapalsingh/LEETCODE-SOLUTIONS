class Solution {
    public boolean isUgly(int n) {
        //Base Case
        if(n<=0){
            return false;
        }

       int[] primeFactors={2,3,5};
       for(int factor:primeFactors){
        while(n%factor==0){
            n=n/factor;
        }
       } 
       return n==1;
    }
}