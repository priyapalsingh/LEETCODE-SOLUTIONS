class Solution {
    public String removeDuplicateLetters(String s) {
        // Last index of each char
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            if (seen[idx]) continue;  // already in stack
            
            // Pop larger chars jo baad me fir aayenge
            while (!stack.isEmpty() && stack.peek() > c && 
                   last[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            seen[idx] = true;
        }
        
        // Build result
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        return sb.toString();
    }
}
