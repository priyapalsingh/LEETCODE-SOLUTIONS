class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // Step 1: Count total original '1's in string s
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        // Step 2: Augment string s with '1' at both ends -> t = '1' + s + '1'
        String t = "1" + s + "1";
        int n = t.length();

        int maxDelta = 0;
        int i = 0;

        // Step 3: Pointers/Indices se max (left 0s + right 0s) length pattern dhundho
        while (i < n) {
            if (t.charAt(i) == '0') {
                // Left 0s block ka start aur end index
                int zero1Start = i;
                while (i < n && t.charAt(i) == '0') {
                    i++;
                }
                int len1 = i - zero1Start; // Left 0s ki length

                // Middle 1s block ka start aur end index
                int oneStart = i;
                while (i < n && t.charAt(i) == '1') {
                    i++;
                }
                int lenOne = i - oneStart;

                // Agar right side par bhi 0s ka block maujood hai
                if (i < n && t.charAt(i) == '0') {
                    int zero2Start = i;
                    while (i < n && t.charAt(i) == '0') {
                        i++;
                    }
                    int len2 = i - zero2Start; // Right 0s ki length

                    // Condition: Middle '1's wala block original string s ka part hona chahiye
                    // (yaani outer augmented '1's nahi hone chahiye)
                    if (oneStart > 0 && (oneStart + lenOne - 1) < n - 1) {
                        maxDelta = Math.max(maxDelta, len1 + len2);
                    }

                    // Next iteration ke liye index ko second 0s block ke start par reset karo
                    i = zero2Start;
                }
            } else {
                i++;
            }
        }

        return totalOnes + maxDelta;
    }
}