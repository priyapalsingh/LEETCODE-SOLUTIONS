class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int maxDist = 0;
        
        // Dono pointers ko ek hi baar traverse karna hai
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                // Agar condition sahi hai, toh distance update karo aur j ko aage badhao
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                // Agar nums1[i] bada hai, toh i ko badhao taaki choti value mile
                i++;
            }
        }
        
        return maxDist;
    }
}