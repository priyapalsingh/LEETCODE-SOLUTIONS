class Solution {
    public String smallestSubsequence(String s) {
       Stack<Character> st=new Stack<>();
       int[] lastindex=new int[26]; //stores the last index of every element at which it was present
       boolean[] seen=new boolean[26];
       for(int i=0;i<s.length();i++){
        lastindex[s.charAt(i)-'a']=i;
       }

       for (int i = 0; i < s.length(); i++){
        char c=s.charAt(i);
        if(seen[c-'a']){
            continue;
        }
        // Pop elements from the stack if:
            // - The stack is not empty
            // - The top of the stack is lexicographically greater than the current character 'c'
            // - The top element appears again later in the string (lastIndex > i)
            while(!st.isEmpty() && st.peek() >c && lastindex[st.peek()-'a']>i){
                seen[st.pop()-'a']=false;
            }
            st.push(c);
            seen[c-'a']=true;
       }
       // 3. Build the final result string from the stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        // Since the stack elements are popped in reverse order, reverse the string before returning
        return sb.reverse().toString();
    }
}