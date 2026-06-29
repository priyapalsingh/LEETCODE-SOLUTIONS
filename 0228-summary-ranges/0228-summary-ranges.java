class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        
        // Edge Case: Agar array khali hai
        if (n == 0) return list;
        
        int i = 0;
        while (i < n) {
            int start = nums[i]; // Range ka shuruat ka point
            
            // Jab tak agla element pichle wale se exact 1 bada hai, aage badhte jao
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            
            // Loop rukne ke baad nums[i] hamara end point hoga
            int end = nums[i];
            
            // Agar start aur end barabar hain, toh single number add karo
            if (start == end) {
                list.add(String.valueOf(start));
            } 
            // Agar alag hain, toh "start->end" format me add karo
            else {
                list.add(start + "->" + end);
            }
            
            // Agli range check karne ke liye i ko aage badhao
            i++;
        }
        
        return list;
    }
}