class Solution {
    public int compress(char[] chars) {
        int len=chars.length;
        int i=0;
        int write=0;

        while(i<len){
            char ch=chars[i];
            int count=0;

            while(i<len && chars[i]==ch){
                count++;
                i++;
            }
            //1.character ko write pointer par daalo
            chars[write++]=ch;
            //if count>1
            if(count>1){
                for(char c:String.valueOf(count).toCharArray()){
                    chars[write++]=c;
                }
            }
        }
        return write;
    }
}