class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;
        
        // right pointer se window ko aage badhayein
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // Agar window mein ek se zyada 0 ho gaye, toh invalid ho gaya.
            // left pointer ko tab tak aage badhao jab tak zeroCount wapas 1 na ho jaye.
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Kyunki humein 1 element delete karna hi karna hai, 
            // toh valid window ki length hoti hai: (right - left + 1) - 1 zero 
            // Jo ki shortcut mein banta hai: right - left
            maxLen = Math.max(maxLen, right - left);
        }
        
        return maxLen;
    }
}