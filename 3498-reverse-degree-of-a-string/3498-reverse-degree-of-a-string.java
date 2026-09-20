class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int rev_pos=26-(c-'a');
            int product=(i+1)*rev_pos;
            sum+=product;
        }
        return sum;
    }
}