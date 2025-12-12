class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer > freq=new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int length=0;
        boolean hasOdd=false;
        for(int i:freq.values()){
            if(i%2==0){
                length+=i;
            }else{//odd length walo se even part utha lenge 
                length +=i-1;
                hasOdd=true;
            }
        }
        if(hasOdd){//agar last mei koi odd bche hai to unme se koi ek utha lenge center mei lgane ke liye 
            length+=1;
        }
        return length;
        
    }
}