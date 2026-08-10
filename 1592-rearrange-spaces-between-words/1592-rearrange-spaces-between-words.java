class Solution {
    public String reorderSpaces(String text) {
        int spaces=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' '){
                spaces++;
            }
        }
        String[] words=text.trim().split("\\s+");
        int wordcount=words.length;
        
        StringBuilder sb=new StringBuilder();
        //edge case
        if(wordcount==1){
            sb.append(words[0]);
            for(int i=0;i<spaces;i++){
                sb.append(' ');
            }
            return sb.toString();
        }

        int spacesbetween=spaces/(wordcount-1);
        int extraspaces=spaces%(wordcount-1);

        for(int i=0;i<wordcount;i++){
            sb.append(words[i]);
        // Aakhri word ke baad between-spaces nahi lagane
            if(i<wordcount-1){
                for(int j=0;j<spacesbetween ; j++){
                    sb.append(' ');
                }
            }
        }
        for (int i = 0; i < extraspaces; i++) {
            sb.append(' ');
        }

        return sb.toString();

        

    }
}