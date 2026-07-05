class Solution {
    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        
        // FIX 2: If leave() is true (found 3 L's), return false.
        if(leave(arr)) {
            return false; 
        }
        
        int absent = 0;
        for(char c : arr){
            if(c == 'A'){
                absent++; 
            }
            if(absent == 2){
                return false; 
            }
        }
        return true; 
    }
    
    private boolean leave(char[] arr){
        int i = 0; 
        int leaves = 0; 
        while(i < arr.length){
            if(arr[i] == 'L'){
                leaves++; 
                if(leaves == 3){
                    return true; 
                }
            } else {
                leaves = 0; 
            }
            
            // FIX 1: Increment i to move to the next character
            i++; 
        }
        return false; 
    }
}