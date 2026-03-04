class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, path, used, result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        // Base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // Try all unused numbers
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            // Choose
            used[i] = true;
            path.add(nums[i]);
            
            // Explore
            backtrack(nums, path, used, result);
            
            // Backtrack
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
