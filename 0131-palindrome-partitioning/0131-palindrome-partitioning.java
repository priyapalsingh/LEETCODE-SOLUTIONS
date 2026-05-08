class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack(0,s,new ArrayList<>(),res);
        return res;
        
    }
    private void backtrack(int start,String s,List<String> temp,List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backtrack(i+1,s,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int low,int high){
        
        while(low < high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return  true;
    }
}