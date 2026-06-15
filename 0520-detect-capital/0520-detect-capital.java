class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        boolean flag1 = true; // Case 1: सब Capital होने चाहिए
        boolean flag2 = true; // Case 2: सब Lowercase होने चाहिए
        boolean flag3 = true; // Case 3: सिर्फ पहला Capital, बाकी Lowercase
        
        // Case 1: Check if all characters are uppercase
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c) == false) {
                flag1 = false;
                break; // एक भी lowercase मिला तो यह केस गलत
            }
        }
        
        // Case 2: Check if all characters are lowercase
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c) == false) {
                flag2 = false;
                break; // एक भी uppercase मिला तो यह केस गलत
            }
        }
        
        // Case 3: Check if only the first character is uppercase and the rest are lowercase
        if (Character.isUpperCase(word.charAt(0))) {
            for (int i = 1; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i)) == false) {
                    flag3 = false;
                    break;
                }
            }
        } else {
            flag3 = false; // अगर पहला ही अक्षर स्मॉल है, तो Case 3 वैसे ही फ़ेल है
        }
        
        // अगर तीनों में से कोई भी एक कंडीशन सही (true) है, तो रिटर्न true होगा
        return flag1 || flag2 || flag3;
    }
}