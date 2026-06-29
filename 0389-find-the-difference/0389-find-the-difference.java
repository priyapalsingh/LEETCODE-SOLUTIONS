class Solution {
    public char findTheDifference(String s, String t) {
        StringBuilder sb=new StringBuilder(t);
       
        for(char c:s.toCharArray()){
            int idx=sb.indexOf(String.valueOf(c));
            sb.deleteCharAt(idx);
        }
        return sb.charAt(0);
    }
}