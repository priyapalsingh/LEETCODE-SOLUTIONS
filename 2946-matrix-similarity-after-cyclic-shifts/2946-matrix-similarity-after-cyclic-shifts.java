class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // n shifts ke baad row wapas original state mein aa jati hai
        // isliye k ko normalize karna zaroori hai
        k = k % n;
        
        // Agar k zero hai, toh koi shift nahi hua, matrix identical hi rahegi
        if (k == 0) return true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Logic: 
                // Even row left shift ho rahi hai, Odd row right shift.
                // Lekin similarity ke liye dono cases mein condition same banti hai:
                // mat[i][j] must be equal to mat[i][(j + k) % n]
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}