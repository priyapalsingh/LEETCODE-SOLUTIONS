class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            boolean foundMatch = false;
            ans[i] = -1; // Default to -1

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    foundMatch = true;
                }
                
                // If we've found the match and the current number in nums2 is greater
                if (foundMatch && nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}