

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> idxList = new ArrayList<>();

        // 1. Valid + active coupons ke INDEX collect karo
        for (int i = 0; i < code.length; i++) {
            if (string_match(code[i]) 
                && businessLine_match(businessLine[i]) 
                && isActive[i]) {
                idxList.add(i);
            }
        }

        // 2. Custom sort:
        //    pehle businessLine order: electronics < grocery < pharmacy < restaurant
        //    fir same businessLine ke andar code lexicographic (ascending)
        idxList.sort((i, j) -> {
            int bi = businessPriority(businessLine[i]);
            int bj = businessPriority(businessLine[j]);
            if (bi != bj) {
                return bi - bj;  // chhota priority pehle
            }
            // same businessLine -> code compare
            return code[i].compareTo(code[j]);
        });

        // 3. Sorted indices se final answer list banao
        List<String> ans = new ArrayList<>();
        for (int i : idxList) {
            ans.add(code[i]);
        }
        return ans;
    }

    // code: sirf A–Z, a–z, 0–9, underscore allowed
    private boolean string_match(String s) {
        return s != null && s.matches("^[A-Za-z0-9_]+$");
    }

    // businessLine allowed values
    private boolean businessLine_match(String b) {
        return "electronics".equals(b)
            || "grocery".equals(b)
            || "pharmacy".equals(b)
            || "restaurant".equals(b);
    }

    // businessLine ke liye custom priority
    private int businessPriority(String b) {
        switch (b) {
            case "electronics": return 0;
            case "grocery":     return 1;
            case "pharmacy":    return 2;
            case "restaurant":  return 3;
            default:            return 4;  // ideally yahan nahi aayega
        }
    }
}