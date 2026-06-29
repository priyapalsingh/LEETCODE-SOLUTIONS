import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // String s ko spaces ke basis par words me todo
        String[] words = s.split(" ");
        
        // Agar donon ki length match nahi karti, toh pattern impossible hai
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Two-way mapping check karne ke liye do Maps
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            // 1. Check Char -> Word mapping
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(ch, word);
            }
            
            // 2. Check Word -> Char mapping (Prevents distinct chars mapping to same word)
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            } else {
                wordToChar.put(word, ch);
            }
        }
        
        return true;
    }
}