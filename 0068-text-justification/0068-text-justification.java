import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();

            // Find how many words fit in the current line
            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder sb = new StringBuilder();

            // Case 1: Last line or line with single word -> Left Justified
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Case 2: Fully Justified line
            else {
                int totalWordLen = 0;
                for (int k = i; k < j; k++) {
                    totalWordLen += words[k].length();
                }

                int totalSpaces = maxWidth - totalWordLen;
                int gaps = numWords - 1;
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = spacePerGap + (extraSpaces > 0 ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(" ");
                        }
                        extraSpaces--;
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to the next batch
        }

        return result;
    }
}