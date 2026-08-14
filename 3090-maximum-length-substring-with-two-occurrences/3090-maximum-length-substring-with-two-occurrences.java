class Solution {
    public int maximumLengthSubstring(String s) {
       int n=s.length();
       int maxlen=0;
       int left=0;
       Map<Character,Integer> map=new HashMap<>();
       for(int right=0;right<n;right++){
        char c=s.charAt(right);
        map.put(c,map.getOrDefault(c,0)+1);
        while(map.get(c)>2){
            char leftchar=s.charAt(left);
            map.put(leftchar,map.get(leftchar)-1);
            left++;
        }
        //ab valid window milgyi ab len calc kro
        maxlen=Math.max(maxlen,right-left+1);
       }
       return maxlen;
    }
}