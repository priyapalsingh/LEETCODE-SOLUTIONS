class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] even = new int[n / 2];
        int[] odd = new int[n / 2];
        
        int i = 0, j = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                even[i++] = x;
            } else {
                odd[j++] = x;
            }
        }

        int[] result = new int[n];
        int k = 0, l = 0;
        
        for (int r = 0; r < n; r++) {
            if (r % 2 == 0) { // Index 'r' check karenge
                result[r] = even[k++];
            } else {
                result[r] = odd[l++];
            }
        }

        return result;
    }
}