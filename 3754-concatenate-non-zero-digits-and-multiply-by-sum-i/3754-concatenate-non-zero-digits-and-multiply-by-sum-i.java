class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0; // Edge case
        
        long x = 0;
        long sum = 0;
        long multiplier = 1; // Digits ko sahi place par rakhne ke liye
        
        int i = n;
        while (i > 0) {
            int digit = i % 10; // Aakhiri digit nikalo
            
            if (digit != 0) {
                x = x + (digit * multiplier); // Digit ko uski sahi place pe add karo
                multiplier *= 10;             // Next non-zero digit ki place value badhao
                sum += digit;
            }
            i /= 10; // Number ko chota karo
        }
        
        return sum * x;
    }
}