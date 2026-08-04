import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        int n = nums.length;
        int idx = 0;
        
        // Min se Max element tak saari values loop karo
        for (int curr = nums[0]; curr <= nums[n - 1]; curr++) {
            if (idx < n && nums[idx] == curr) {
                idx++; // Element target me present hai, pointer aage badhao
            } else {
                list.add(curr); // Missing element mila, list me add karo
            }
        }
        
        return list;
    }
}