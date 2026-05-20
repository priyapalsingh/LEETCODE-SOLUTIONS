class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        
        // 1 se n tak ke numbers ke liye frequency array (size n + 1)
        int[] freq = new int[n + 1];
        int commonCount = 0;
        
        for (int i = 0; i < n; i++) {
            // A[i] ka count badhao
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                commonCount++;
            }
            
            // B[i] ka count badhao
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                commonCount++;
            }
            
            // Current index tak jitne common mile use C[i] mein daal do
            C[i] = commonCount;
        }
        
        return C;
    }
}