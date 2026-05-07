class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Step 1: Prefix Maximum nikalna
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        
        // Step 2: Suffix Minimum nikalna
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        // Step 3: Groups pehchaanna aur max value fill karna
        int i = 0;
        while (i < n) {
            int j = i;
            int currentMax = nums[i];
            
            // Jab tak current group chal raha hai
            while (j < n - 1 && prefixMax[j] > suffixMin[j + 1]) {
                j++;
                currentMax = Math.max(currentMax, nums[j]);
            }
            
            // Is group ke saare elements ka answer currentMax hoga
            for (int k = i; k <= j; k++) {
                ans[k] = currentMax;
            }
            
            i = j + 1; // Agle group par move karein
        }
        
        return ans;
    }
}