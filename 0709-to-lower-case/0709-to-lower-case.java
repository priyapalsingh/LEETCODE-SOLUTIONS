class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            // Agar character uppercase hai ('A' se 'Z' ke beech)
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32)); // Lowercase me convert karke append karo
            } else {
                sb.append(c); // Baaki characters (digits/symbols/already lowercase) ko as it is append karo
            }
        }

        return sb.toString();
    }
}