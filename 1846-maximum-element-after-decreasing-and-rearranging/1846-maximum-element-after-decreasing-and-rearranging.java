import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        
        // Step 1: Array ko sort karo taaki rearrange waali condition handle ho jaye
        Arrays.sort(arr);
        
        // Condition 1: Pehla element hamesha 1 hona chahiye
        arr[0] = 1;
        
        // Step 2: Baaki elements par greedy check lagao
        for (int i = 1; i < n; i++) {
            // Agar current element pichle element se 1 se zyada bada hai,
            // toh use decrease karke max allowable value (arr[i-1] + 1) par le aao
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        
        // Sort hone aur modify hone ke baad, aakhri element hi sabse bada hoga
        return arr[n - 1];
    }
}