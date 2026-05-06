class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Apply Gravity (Right side shift)
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // Sabse right-most khali jagah
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j - 1; // Obstacle ke peeche wali jagah ab empty hogi
                } else if (boxGrid[i][j] == '#') {
                    // Stone ko empty spot par move karo
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Step 2: Rotate 90 Degrees Clockwise
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return result;
    }
}