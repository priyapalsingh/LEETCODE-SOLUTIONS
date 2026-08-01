class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
       int[][] count=new int[n][11]; //acc to constraints
/*Ek 2D frequency array banayein: count[10][11] .pick array par loop chala kar har player ke color frequency count ko badhayein: count[player][color]++Ab har player i ke liye check karein ki kya kisi bhi color ki count i + 1 hai. Agar hai, toh winner count 1 se badha dein.*/ 
       for(int[] p:pick){
        int player=p[0];
        int color=p[1];
        count[player][color]++;
       }
       int winner=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<11;j++){
            if(count[i][j]>i){
                winner++;
                break;
            }
        }
       }
       return winner;
    }
}