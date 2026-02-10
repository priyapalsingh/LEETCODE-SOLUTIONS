class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        // Iterate through every possible starting index 'i'
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            int[] distinctCounts = new int[2]; // [0] for evens, [1] for odds

            // Expand the subarray from index 'i' to 'j'
            for (int j = i; j < n; j++) {
                int val = nums[j];
                
                // add returns true if the element was not already present
                if (seen.add(val)) {
                    // Update count based on parity (val % 2)
                    distinctCounts[val % 2]++;
                }

                // If distinct even count == distinct odd count, it's balanced
                if (distinctCounts[0] == distinctCounts[1]) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen; 
    }
}