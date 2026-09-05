class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]==word.charAt(0) && dfs(board,word,r,c,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int r,int c,int i,boolean[][] visited){
        int rows=board.length;
        int cols=board[0].length;
        if(i==word.length()){
            return true;
        }

        if(r<0 || r>=rows || c<0 || c>=cols || visited[r][c] || word.charAt(i)!=board[r][c] ){
            return false;
        }

        visited[r][c]=true;
        boolean found=dfs(board,word,r+1,c,i+1,visited) || dfs(board,word,r-1,c,i+1,visited) || dfs(board,word,r,c+1,i+1,visited) || dfs(board,word,r,c-1,i+1,visited);

        visited[r][c]=false;

        return found;


    }
}