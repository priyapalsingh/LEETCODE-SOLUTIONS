class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int maxones=0,maxrowindex=0;
        for(int i=0;i<row;i++){
            int currones=0;
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    currones++;
                }  
            }
            if(currones>maxones){
                maxones=currones;
                maxrowindex=i;
            }
        }
        return new int[]{maxrowindex,maxones};
    }
}