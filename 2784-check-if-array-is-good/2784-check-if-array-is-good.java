class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        // base[n] ki length n + 1 hoti hai. 
        // Toh humara 'n' (max element) hoga: len - 1
        int n = len - 1; 
        
        // 1. Check karo ki aakhri element 'n' hai ya nahi
        if (nums[len - 1] != n) return false;

        // 2. Check karo ki 1 se n-1 tak saare numbers line se hain
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        
        // 3. Check karo ki aakhri do elements same hain (dono 'n' hone chahiye)
        // Kyunki humne loop mein i < n tak check kiya hai, nums[n-1] verify ho chuka hai.
        // Hame bas dekhna hai ki nums[n-1] == nums[n] hai ya nahi.
        return nums[len - 2] == n;
    }
}