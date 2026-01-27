class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        // Sort to handle duplicates (optional but good practice)
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, current, result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, 
                          List<Integer> current, List<List<Integer>> result) {
        
        // Base case: Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: Target exceeded
        if (target < 0) {
            return;
        }
        
        // Try all candidates from 'start' index
        for (int i = start; i < candidates.length; i++) {
            // Optimization: Skip if too large
            if (candidates[i] > target) {
                break;
            }
            
            current.add(candidates[i]);
            // 'i' not 'i+1' → Unlimited usage allowed!
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);  // Backtrack
        }
    }
}
