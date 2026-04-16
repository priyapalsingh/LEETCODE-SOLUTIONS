class Solution {
    public int arrayPairSum(int[] nums) {
        // 1. Array ko sort karo taaki kareeb wale numbers saath aa jayein
        Arrays.sort(nums);
        
        int sum = 0;
        
        // 2. Har pair ka pehla (chota) element uthao
        // Index: 0, 2, 4, 6... (ek chodd kar ek)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}