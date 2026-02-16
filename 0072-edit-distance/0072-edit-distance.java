//RECURSION SOLUTION

class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        return  min( word1, word2, n,m);
        
    }
    private int min(String word1,String word2,int i,int j){
        if(i==0) return j;
        if(j==0) return i;

        if(word1.charAt(i-1)==word1.charAt(j-1)){
            return min(word1,word2,i-1,j-1);
        }
        else{
            //deletion
            int delete= 1+min(word1,word2,i-1,j);
            //insert
            int insert=1+min(word1,word2,i,j-1);
            //replace
            int replace=1+min(word1,word2,i-1,j-1);

             return Math.min(delete ,Math.min(insert,replace));
        }
       
    }

}