class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int op = 0;
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int freq : map.values()) {
            // Agar kisi element ki frequency 1 hai, toh use kabhi empty nahi kar sakte
            if (freq == 1) {
                return -1;
            }
            
            // Short ceiling division trick for dividing by 3: (freq + 2) / 3
            op += (freq + 2) / 3;
        }
        
        return op;
    }
}