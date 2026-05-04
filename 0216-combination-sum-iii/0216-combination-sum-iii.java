class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(1,k,target,new ArrayList<>(),result);
        return result;
        
    }
    private void backtrack(int start,int k,int target,List<Integer> temp,List<List<Integer>> result){
        if(temp.size()==k ){
            if(target==0){
                 result.add(new ArrayList<>(temp));
                 return;
            }
           
        }
        for(int i=start;i<=9;i++){
            // Agar i, bache hue n se bada hai, toh aage check karne ki zarurat nahi
            if(i>target) break;
            temp.add(i);
            backtrack(i+1,k,target-i,temp,result);
            temp.remove(temp.size()-1);
        }
    }

}