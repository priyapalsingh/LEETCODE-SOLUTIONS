class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
       Arrays.sort(nums);
       int product1=1;
       int product2=1;
       //case 1        
       for(int i=n-3;i<n;i++){
        product1*=nums[i];
       } 
       //case 2
       product2*=nums[0]*nums[1]*nums[n-1];
       return Math.max(product1,product2);
    }
}