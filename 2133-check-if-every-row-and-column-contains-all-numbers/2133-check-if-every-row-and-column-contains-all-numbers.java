class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            Set<Integer> rowset=new HashSet<>();
            Set<Integer> colset=new HashSet<>();
            for(int j=0;j<n;j++){
                if(!rowset.add(matrix[i][j])) return false;
                if(!colset.add(matrix[j][i])) return false; 
            }

        }
       return true; 
    }
}