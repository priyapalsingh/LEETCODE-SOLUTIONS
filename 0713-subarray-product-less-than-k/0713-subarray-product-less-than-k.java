class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int product=1;
        int left=0;
        for(int right=0;right<n;right++){
            product*=nums[right];

            while(product>=k){//agar invalid hai to left se htao element
                product/=nums[left];
                left++;
            }
            count+=right-left+1; //Is valid window [left, right] mein banne wale saare naye subarrays add karo
        }
        return count;
    }
}