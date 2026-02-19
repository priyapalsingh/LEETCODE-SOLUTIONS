class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result=new ArrayList<>();
         
        for(int i=0;i<n;i++){
            List<Integer> level=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    level.add(1);
                }else{
                    int prev1=result.get(i-1).get(j-1);
                    int prev2 = result.get(i - 1).get(j);
                    level.add(prev1 + prev2);
                }
            }
            result.add(level);
        }
        return result;
    }
}