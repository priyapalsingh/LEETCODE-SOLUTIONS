class Solution {
    public int[][] generateMatrix(int n) {
        // Initialize the n x n matrix
        int[][] matrix = new int[n][n];
        
        // Define the boundaries
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        // Value to fill in the matrix
        int num = 1;
        
        while (top <= bottom && left <= right) {
            // 1. Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // Move the top boundary down
            
            // 2. Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // Move the right boundary left
            
            // 3. Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--; // Move the bottom boundary up
            }
            
            // 4. Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; // Move the left boundary right
            }
        }
        
        return matrix;
    }
}