class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }
        
        int dir = 1;
        int curr = 0;
        
        for(char ch : s.toCharArray()){
            rows[curr].append(ch);           // 1. ADD char FIRST ✓

            //now move 
            curr += dir;
            
            //  CHECK boundary & reverse BEFORE moving
            if(curr == 0 || curr == numRows-1){
                dir = -dir;
            }
            
           
            
        }
        
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }
}
