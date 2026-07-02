import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Uppercase aur Lowercase dono daal diye taaki case ki tension na rahe
        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";
        
        List<String> validWords = new ArrayList<>();
        
        for (String word : words) {
            // Word ke pehle character se pata karo ki usko kis row me hona chahiye
            String targetRow = "";
            char firstChar = word.charAt(0);
            
            if (row1.indexOf(firstChar) != -1) {
                targetRow = row1;
            } else if (row2.indexOf(firstChar) != -1) {
                targetRow = row2;
            } else {
                targetRow = row3;
            }
            
            // Ab check karo ki word ke saare characters usi targetRow me hain ya nahi
            boolean isValid = true;
            for (char ch : word.toCharArray()) {
                if (targetRow.indexOf(ch) == -1) { // Agar character targetRow me nahi mila
                    isValid = false;
                    break;
                }
            }
            
            // Agar saare characters ek hi row se hain, toh list me add kar do
            if (isValid) {
                validWords.add(word);
            }
        }
        
        // ArrayList ko wapas String array me convert karke return karo
        return validWords.toArray(new String[0]);
    }
}