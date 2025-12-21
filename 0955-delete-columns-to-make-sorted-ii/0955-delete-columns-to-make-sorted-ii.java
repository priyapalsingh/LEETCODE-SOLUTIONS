class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        // fixed[i] == true means strs[i] < strs[i+1] is already determined
        boolean[] fixed = new boolean[n - 1];
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean shouldDelete = false;

            // 1) Check if this column breaks order for any unfixed pair
            for (int row = 0; row < n - 1; row++) {
                if (!fixed[row] &&
                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    deletions++;
                    shouldDelete = true;
                    break;  // move to next column
                }
            }

            if (shouldDelete) {
                continue;
            }

            // 2) If column is kept, update fixed[] for pairs that become strictly ordered
            for (int row = 0; row < n - 1; row++) {
                if (!fixed[row] &&
                    strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    fixed[row] = true;
                }
            }
        }

        return deletions;
    }
}
