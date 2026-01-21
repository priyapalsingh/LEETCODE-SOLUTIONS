import java.util.*;

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;

        // value -> original index
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(nums[i], i);
        }

        // sort nums
        Arrays.sort(nums);

        long operations = n; // minimum removals
        int prevIndex = pos.get(nums[0]);

        for (int i = 1; i < n; i++) {
            int currIndex = pos.get(nums[i]);

            if (currIndex < prevIndex) {
                operations += (n - i);
            }
            prevIndex = currIndex;
        }

        return operations;
    }
}
