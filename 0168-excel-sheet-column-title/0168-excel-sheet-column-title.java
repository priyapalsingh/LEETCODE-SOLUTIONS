class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            // Shift to 0-indexed to handle the lack of a '0' character safely
            columnNumber--; 
            
            // Get the character corresponding to the remainder
            char remainderChar = (char) ('A' + (columnNumber % 26));
            result.append(remainderChar);
            
            // Move to the next position
            columnNumber /= 26;
        }
        
        // Since we build the string from right to left, we must reverse it
        return result.reverse().toString();
    }
}