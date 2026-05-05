class Solution {
    public List<String> generateParenthesis(int n) { 
        int open=0;
        int close=0;
        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        backtrack(n,sb,open,close,result) ;
        return result;      
    }
    private void backtrack(int n,StringBuilder sb,int open,int close,List<String> result){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return;
        }

        if(open<n){
            //hum abhi open bracket add kar skte hai 
            sb.append("(");
            backtrack(n,sb,open+1,close,result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            //closing bracket add kro agar wo balance kar ske
            sb.append(")");
            backtrack(n,sb,open,close+1,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}