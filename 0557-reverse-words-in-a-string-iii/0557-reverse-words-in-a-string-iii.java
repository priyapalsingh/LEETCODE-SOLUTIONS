class Solution {
    public String reverseWords(String s) {
        // String ko space ke basis par divide karte hain
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Har word ko reverse karte hain
            StringBuilder word = new StringBuilder(words[i]);
            result.append(word.reverse());

            // Words ke beech me space add karte hain (last word ko chhod kar)
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}