class Solution {
    public int smallestNumber(int n, int t) {
       boolean flag=false; 
       while(flag!=true){
        int productofdigits=digitproduct(n);
        if(productofdigits % t==0){
            flag=true;
            return n;           
        }
        n++;
       }
       return -1;
    }
    private int digitproduct(int n){
        
        int product=1;
        while(n>0){
            int digit=n%10;
            product*=digit;
            n=n/10;
        }
        return product;
    }
}