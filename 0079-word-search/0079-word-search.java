class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(word.charAt(0)==board[r][c] && dfs(0,board,word,visited,r,c)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,char[][] board, String word ,boolean[][] visited,int r,int c){
        int rows=board.length;
        int cols=board[0].length;

        if(i==word.length()){
            return true;
        }

        if(r<0||r>=rows||c<0||c>=cols||visited[r][c]||word.charAt(i)!=board[r][c]){
            return false;
        }

        visited[r][c]=true;
        boolean flag=dfs(i+1,board,word,visited,r+1,c) || dfs(i+1,board,word,visited,r-1,c) || dfs(i+1,board,word,visited,r,c+1) || dfs(i+1,board,word,visited,r,c-1);
        visited[r][c]=false;

        return flag;


    }
}