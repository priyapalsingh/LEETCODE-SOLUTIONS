class Solution {
    public int minMoves(int[] nums, int limit) {
        // Difference array to record change in moves for each possible sum S
        // Range of S is [2, 2 * limit]
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            // Case analysis for a pair (a, b) with target sum T:
            // 1. T in [2, min(a, b) + 1): 2 moves (change both)
            // 2. T in [min(a, b) + 1, a + b): 1 move (change one)
            // 3. T = a + b: 0 moves (already equal)
            // 4. T in (a + b, max(a, b) + limit]: 1 move (change one)
            // 5. T in (max(a, b) + limit, 2 * limit]: 2 moves (change both)

            int minVal = Math.min(a, b);
            int maxVal = Math.max(a, b);

            // Initially assume 2 moves for all sums [2, 2 * limit]
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // Reduce to 1 move for sums in range [minVal + 1, maxVal + limit]
            diff[minVal + 1] -= 1;
            diff[maxVal + limit + 1] += 1;

            // Reduce to 0 moves for exactly T = a + b
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
        }

        int minMoves = n;
        int currentMoves = 0;
        // Sweep through the difference array to find the minimum
        for (int i = 2; i <= 2 * limit; i++) {
            currentMoves += diff[i];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
