class Solution {
    String[] map={
        "" ,//0
        "" ,//1
        "abc", //2
        "def", //3
        "ghi", //4
        "jkl", //5
        "mno", //6
        "pqrs", //7
        "tuv" ,//8
        "wxyz" //9
    } ; 

    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
       if(digits.length()==0){
        return result;
       }
       
        backtrack(0,digits,result,new StringBuilder());
        return result;
    }
    private void backtrack(int index,String digits,List<String> result, StringBuilder current){
        if(index==digits.length()){
            result.add(current.toString());
            return ;
        }
        StringBuilder sb=new StringBuilder();
        int digit = digits.charAt(index) - '0';
        String dig=map[digit];

        for(char c:dig.toCharArray()){
            current.append(c);
            backtrack(index+1,digits,result,current);
            current.deleteCharAt(current.length()-1);
        }
        
    }
}
