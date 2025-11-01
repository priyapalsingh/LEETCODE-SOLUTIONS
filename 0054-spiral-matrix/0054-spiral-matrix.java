class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       ArrayList<Integer> list=new ArrayList<>();
       int top=0,bottom=n-1,left=0,right=m-1;
       while(top<=bottom && left<=right){
         //top-->right top
        for(int i=left;i<=right;i++){
            list.add(mat[top][i]);
        }
        top++;
       
       //top+1-->bottom right
       for(int i=top;i<=bottom;i++){
        list.add(mat[i][right]);
       }
       right--;
       //right-->left
       if(top<=bottom){
        for(int i=right;i>=left;i--){
            list.add(mat[bottom][i]);
        }
        bottom--;
       }
       if(left<=right){
        for(int i=bottom;i>=top;i--){
            list.add(mat[i][left]);
        }
        left++;
       }

       }
       return list;
      
    }
}