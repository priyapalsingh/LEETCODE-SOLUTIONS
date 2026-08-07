import java.util.Arrays;

public class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Count prime factors of t (2, 3, 5, 7)
        long tempT = t;
        int t2 = 0, t3 = 0, t5 = 0, t7 = 0;
        while (tempT % 2 == 0) { t2++; tempT /= 2; }
        while (tempT % 3 == 0) { t3++; tempT /= 3; }
        while (tempT % 5 == 0) { t5++; tempT /= 5; }
        while (tempT % 7 == 0) { t7++; tempT /= 7; }
        
        // If t has other prime factors, it's impossible to satisfy with digits 1-9
        if (tempT > 1) {
            return "-1";
        }

        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
        }

        // Step 2: Track prime factor requirements for the remaining positions
        // counts[i][0/1/2/3] represents remaining counts of 2, 3, 5, 7 needed after position i
        int[][] counts = new int[n + 1][4];
        counts[0][0] = t2;
        counts[0][1] = t3;
        counts[0][2] = t5;
        counts[0][3] = t7;

        int firstZeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0 && firstZeroIdx == -1) {
                firstZeroIdx = i;
            }
            // Consume prime factors using the current digit if it's non-zero
            int d = digits[i];
            int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
            if (d > 0) {
                int td = d;
                while (td % 2 == 0) { c2++; td /= 2; }
                while (td % 3 == 0) { c3++; td /= 3; }
                while (td % 5 == 0) { c5++; td /= 5; }
                while (td % 7 == 0) { c7++; td /= 7; }
            }
            counts[i + 1][0] = Math.max(0, counts[i][0] - c2);
            counts[i + 1][1] = Math.max(0, counts[i][1] - c3);
            counts[i + 1][2] = Math.max(0, counts[i][2] - c5);
            counts[i + 1][3] = Math.max(0, counts[i][3] - c7);
        }

        // Case A: The original number itself is zero-free and already satisfies t
        if (firstZeroIdx == -1 && counts[n][0] == 0 && counts[n][1] == 0 && counts[n][2] == 0 && counts[n][3] == 0) {
            return num;
        }

        // Step 3: Backtrack from right to left to find where we can increment a digit
        int limit = (firstZeroIdx != -1) ? firstZeroIdx : n - 1;
        for (int i = limit; i >= 0; i--) {
            int startDigit = digits[i] + 1;
            for (int d = startDigit; d <= 9; d++) {
                int[] nextReq = new int[4];
                int td = d;
                int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
                while (td % 2 == 0) { c2++; td /= 2; }
                while (td % 3 == 0) { c3++; td /= 3; }
                while (td % 5 == 0) { c5++; td /= 5; }
                while (td % 7 == 0) { c7++; td /= 7; }

                nextReq[0] = Math.max(0, counts[i][0] - c2);
                nextReq[1] = Math.max(0, counts[i][1] - c3);
                nextReq[2] = Math.max(0, counts[i][2] - c5);
                nextReq[3] = Math.max(0, counts[i][3] - c7);

                int remVacancies = n - 1 - i;
                int minLenNeeded = getMinimumLengthNeeded(nextReq[0], nextReq[1], nextReq[2], nextReq[3]);

                if (minLenNeeded <= remVacancies) {
                    // Valid prefix found! Build the prefix + suffix
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < i; j++) sb.append(digits[j]);
                    sb.append(d);
                    
                    // Fill remaining slots greedily to maintain the smallest values
                    String suffix = generateSmallestSuffix(nextReq[0], nextReq[1], nextReq[2], nextReq[3], remVacancies);
                    sb.append(suffix);
                    return sb.toString();
                }
            }
        }

        // Case B: If no number of length `n` can be formed, expand to length `n + 1` or more
        int totalMinLen = getMinimumLengthNeeded(t2, t3, t5, t7);
        int finalLen = Math.max(n + 1, totalMinLen);
        return generateSmallestSuffix(t2, t3, t5, t7, finalLen);
    }

    // Helper to compute the minimum number of digits needed to clear prime factor requirements
    private int getMinimumLengthNeeded(int r2, int r3, int r5, int r7) {
        int count = r7 + r5; // 7s and 5s can only be filled by digits 7 and 5
        int pairs3 = r3 / 2;
        int rem3 = r3 % 2;
        count += pairs3;    // Pairs of 3 make digit 9

        // Combine remaining 2s and 3s efficiently
        int rem2 = r2;
        if (rem3 > 0) {     // If there is an isolated 3
            if (rem2 >= 1) { rem2 -= 1; count++; } // 2 * 3 = 6 (1 digit)
            else { count++; }                      // Just digit 3 (1 digit)
        }
        
        count += rem2 / 3;  // Triplets of 2 make digit 8
        int left2 = rem2 % 3;
        if (left2 > 0) count++; // Remaining 2s make digit 2 or 4 (1 digit)
        
        return count;
    }

    // Helper to generate the lexicographically smallest valid suffix of a specified length
    private String generateSmallestSuffix(int r2, int r3, int r5, int r7, int length) {
        int[] suffixDigits = new int[length];
        Arrays.fill(suffixDigits, 1);
        int idx = length - 1;

        // Fill right-to-left using largest digits to keep the left side minimal (e.g., loaded with 1s)
        while (r7 > 0) { suffixDigits[idx--] = 7; r7--; }
        while (r5 > 0) { suffixDigits[idx--] = 5; r5--; }

        // Combine 2s and 3s using greedily mapped digits 9, 8, 6, 4, 3, 2
        while (r3 >= 2) { suffixDigits[idx--] = 9; r3 -= 2; }
        while (r2 >= 3) { suffixDigits[idx--] = 8; r2 -= 3; }

        if (r3 == 1 && r2 == 2) { suffixDigits[idx--] = 6; suffixDigits[idx--] = 2; r3 = 0; r2 = 0; }
        else if (r3 == 1 && r2 == 1) { suffixDigits[idx--] = 6; r3 = 0; r2 = 0; }
        else if (r3 == 1 && r2 == 0) { suffixDigits[idx--] = 3; r3 = 0; }
        else if (r3 == 0 && r2 == 2) { suffixDigits[idx--] = 4; r2 = 0; }
        else if (r3 == 0 && r2 == 1) { suffixDigits[idx--] = 2; r2 = 0; }

        Arrays.sort(suffixDigits); // Ensure it's non-decreasing for the lowest numerical value
        StringBuilder sb = new StringBuilder();
        for (int d : suffixDigits) sb.append(d);
        return sb.toString();
    }
}
