class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int leftSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int rightSum = totalSum - leftSum;
                
                // If sums are equal, both directions work
                if (leftSum == rightSum) {
                    count += 2;
                } 
                // If difference is 1, only one direction works
                else if (Math.abs(leftSum - rightSum) == 1) {
                    count += 1;
                }
            } else {
                leftSum += nums[i];
            }
        }

        return count;
    }
}