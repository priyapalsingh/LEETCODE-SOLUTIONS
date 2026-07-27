class Solution {
    public String compressedString(String word) {
        int len = word.length();
        StringBuilder comp = new StringBuilder();
        int i = 0;

        while (i < len) {
            char ch = word.charAt(i);
            int count = 0;

            // Boundary check (i < len), Same char check, aur Max 9 count check
            while (i < len && word.charAt(i) == ch && count < 9) {
                count++;
                i++;
            }

            comp.append(count);
            comp.append(ch);
        }

        return comp.toString();
    }
}