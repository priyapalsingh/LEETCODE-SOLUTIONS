class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        
        // Pass 1: Pehle saare pivot se chote elements daalo
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[index++] = nums[i];
            }
        }
        
        // Pass 2: Fir saare pivot ke barabar vaale elements daalo
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                result[index++] = nums[i];
            }
        }
        
        // Pass 3: Akhiri mein saare pivot se bade elements daalo
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                result[index++] = nums[i];
            }
        }
        
        return result;
    }
}