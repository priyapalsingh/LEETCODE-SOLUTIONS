class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Mapping array: initially har character khud se mapped hai
        // 'a' -> 'a', 'b' -> 'b', etc.
        char[] mapping = new char[26];
        for (int i = 0; i < 26; i++) {
            mapping[i] = (char) ('a' + i);
        }

        // Step 1: s1 aur s2 ke characters ko map karo
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // Dono characters ki current sabse choti mapped value nikalo
            char minChar = (mapping[c1 - 'a'] < mapping[c2 - 'a']) ? mapping[c1 - 'a'] : mapping[c2 - 'a'];
            char maxChar = (mapping[c1 - 'a'] > mapping[c2 - 'a']) ? mapping[c1 - 'a'] : mapping[c2 - 'a'];

            // Pure mapping array me jahan bhi maxChar mapped hai, use aur chota (minChar) kar do
            if (minChar != maxChar) {
                for (int j = 0; j < 26; j++) {
                    if (mapping[j] == maxChar) {
                        mapping[j] = minChar;
                    }
                }
            }
        }

        // Step 2: baseStr ko convert karo direct mapping se
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char curr = baseStr.charAt(i);
            sb.append(mapping[curr - 'a']); // Direct O(1) replacement
        }

        return sb.toString();
    }
}