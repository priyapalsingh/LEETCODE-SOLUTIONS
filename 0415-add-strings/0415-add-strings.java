class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int i = num1.length() - 1; // num1 ka last digit pointer
        int j = num2.length() - 1; // num2 ka last digit pointer
        int carry = 0;

        // Jab tak dono strings mein digits baaki hain ya carry bacha hai
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10; // Agle digit ke liye carry update karo
            
            result.append(sum % 10); // Current digit add karo

            i--;
            j--;
        }

        // Digits peeche se add hue the, isliye reverse karke return karenge
        return result.reverse().toString();
    }
}