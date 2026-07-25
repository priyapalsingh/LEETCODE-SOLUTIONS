import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        // 1. Array ko sort karein
        Arrays.sort(nums);
        
        // 2. Median dhoondein
        int median = nums[nums.length / 2];
        int moves = 0;
        
        // 3. Median se absolute differences add karein
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}