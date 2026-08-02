class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]==word.charAt(0) && dfs(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word ,int r,int c, int index){
         int rows=board.length;
         int cols=board[0].length;

         if(index==word.length()){
            return true;
         }

         if( r<0 || r>=rows || c<0 || c>=cols || board[r][c]!=word.charAt(index) ){
            return false;
         }

         char temp=board[r][c];
         board[r][c]='#';

         boolean found=dfs(board,word,r-1,c,index+1) || dfs(board,word,r+1,c,index+1) || dfs(board,word,r,c+1,index+1) || dfs(board,word,r,c-1,index+1);

         board[r][c]=temp;
         return found;

    }
}