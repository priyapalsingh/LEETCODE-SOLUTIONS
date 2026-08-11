class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int prefixsum=nums[0];
        for(int right=1;right<n;right++){
            if(nums[right]==nums[right-1]+1){
                prefixsum+=nums[right];  
            }else{
                break;
            }
        }
        // Step 2: Array elements ko Set me dalo fast lookup ke liye
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Check karo ki minimum value kaunsi missing hai (prefixsum se start karke)
        int minval = prefixsum;
        while (set.contains(minval)) {
            minval++;
        }
        return minval;
       
        
    }
}