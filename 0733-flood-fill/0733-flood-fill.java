class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og=image[sr][sc];
        if(color==og) return image;
         dfs(sr,sc,image,color,og);
         return image;
       
    }
    private void dfs(int r,int c,int[][] image,int color,int og){
        int rows=image.length;
        int cols=image[0].length;
        if(r<0 || r>=rows ||c<0 || c>=cols ){
            return ;
        }
        if(image[r][c] !=og) return ;
        image[r][c]=color;

        dfs(r-1,c,image,color,og);
        dfs(r+1,c,image,color,og);
        dfs(r,c+1,image,color,og);
        dfs(r,c-1,image,color,og);

        
    }
}