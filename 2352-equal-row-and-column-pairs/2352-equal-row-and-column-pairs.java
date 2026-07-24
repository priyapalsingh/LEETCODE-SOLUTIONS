class Solution {
    public int equalPairs(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       //transpose matrix
       int[][] mat=new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            mat[i][j]=grid[j][i];
        }
       } 
       int count=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<mat.length;j++){
            if(Arrays.equals(grid[i],mat[j])){
                count++;
            }
        }
       }
       return count;
    }
}