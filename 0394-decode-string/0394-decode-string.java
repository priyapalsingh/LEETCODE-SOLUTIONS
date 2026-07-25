class Solution {
    public String decodeString(String s) {
       Stack<Integer> number=new Stack<>();
       Stack<StringBuilder> word=new Stack<>();
       StringBuilder currentString = new StringBuilder();
       int k=0;
       for(char ch:s.toCharArray()){
        if(Character.isDigit(ch)){
            k=k*10+ (ch-'0');
        }
        else if(ch=='['){
            number.push(k);
            word.push(currentString);

            //reset the currentString
            currentString=new StringBuilder();
            k=0;
        }
        else if(ch==']'){
            StringBuilder decodedString=word.pop();
            int currentk=number.pop();

            //append into string
            for(int i=0;i<currentk;i++){
                decodedString.append(currentString);
            }
            currentString=decodedString;
        }else{
            currentString.append(ch);
        }
       }
       return currentString.toString();

    }
}