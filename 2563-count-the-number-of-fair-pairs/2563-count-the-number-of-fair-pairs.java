import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array first so we can use the two-pointer technique
        Arrays.sort(nums);
        
        // The number of pairs in the range [lower, upper] is exactly:
        // (Pairs <= upper) - (Pairs <= lower - 1)
        return countLessOrEqual(nums, upper) - countLessOrEqual(nums, lower - 1);
    }
    
    // Helper function to count pairs with a sum less than or equal to a target
    private long countLessOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        long count = 0;
        
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                // If the sum is valid, then all elements between left and right 
                // paired with 'left' are also valid (because the array is sorted).
                count += (right - left);
                left++; // Move left pointer up to check the next element
            } else {
                // If the sum is too big, move the right pointer down to make it smaller
                right--;
            }
        }
        
        return count;
    }
}