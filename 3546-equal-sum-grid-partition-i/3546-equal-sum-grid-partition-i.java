class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long totalsum=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                totalsum+=grid[i][j];
            }
        }
        if(totalsum % 2 !=0){
            return false;
        }
        long target=totalsum/2;

        long prefixRowSum=0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
              prefixRowSum +=grid[i][j];  
            }
            if(prefixRowSum == target){
                return true;
            }
        }

        long colPrefixSum = 0;
        for (int j = 0; j < n - 1; j++) { // n - 1 because sections must be non-empty
            for (int i = 0; i < m; i++) {
                colPrefixSum += grid[i][j];
            }
            if (colPrefixSum == target) {
                return true;
            }
        }

       return false; 
    }
}