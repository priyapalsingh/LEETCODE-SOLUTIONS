class Solution {
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int replacingNumber=sum(nums[i]);
            nums[i]=replacingNumber;
        }
        Arrays.sort(nums);
        return nums[0];
    }
    private int sum(int number){
        int sumofdigits=0;
        while(number>0){
            
        int digit=number%10;
        sumofdigits+=digit;
        number=number/10;

        }
        return sumofdigits;
        
    }
    
}