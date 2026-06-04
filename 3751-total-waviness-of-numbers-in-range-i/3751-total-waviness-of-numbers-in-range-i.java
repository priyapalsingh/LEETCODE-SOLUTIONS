class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalSum = 0;
        
        for (int i = num1; i <= num2; i++) {
            totalSum += calculateWaviness(i);
        }
        
        return totalSum;
    }
    
    private int calculateWaviness(int num) {
        // Any number with fewer than 3 digits has a waviness of 0
        if (num < 100) {
            return 0;
        }
        
        // Convert the number to a string to easily access individual digits
        String s = Integer.toString(num);
        int count = 0;
        
        // The first and last digits cannot be peaks or valleys, so we loop from 1 to length - 2
        for (int i = 1; i < s.length() - 1; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            
            // Check for Peak: strictly greater than both neighbors
            if (curr > prev && curr > next) {
                count++;
            }
            // Check for Valley: strictly less than both neighbors
            else if (curr < prev && curr < next) {
                count++;
            }
        }
        
        return count;
    }
}