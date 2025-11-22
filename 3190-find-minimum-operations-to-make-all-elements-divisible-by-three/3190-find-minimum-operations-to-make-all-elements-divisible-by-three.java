class Solution {
    public int minimumOperations(int[] nums) {
        int numberofStep=0;
        for(int num:nums){
            int addone=addstep(num);
            int minusone=minusstep(num);
            numberofStep+=Math.min(addone,minusone);
        }
        return numberofStep;
        
    }
    private int addstep(int num){
        int count=0;
        while(num % 3 !=0){
            num+=1;
            count++;
        }
        return count;
    }
    private int minusstep(int num){
        int count=0;
        while(num % 3 !=0){
            num-=1;
            count++;
        }
        return count;
    }
}