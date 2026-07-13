import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // A master string containing all possible sequential digits
        String digits = "123456789";
        
        // We only care about numbers with lengths between 2 and 9
        for (int length = 2; length <= 9; length++) {
            
            // Slide a window of size 'length' across the master string
            for (int i = 0; i <= 9 - length; i++) {
                // Extract the substring and convert it to an integer
                String sub = digits.substring(i, i + length);
                int num = Integer.parseInt(sub);
                
                // If it falls within our target range, add it to the result
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}