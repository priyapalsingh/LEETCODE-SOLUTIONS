class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                Queue<Character> qu=new LinkedList<>();
                while(!st.isEmpty() && st.peek()!='('){
                    qu.add(st.pop());
                }
                if(!st.isEmpty()){
                    st.pop();
                }

                while(!qu.isEmpty()){
                    st.push(qu.poll());
                 }
            }
            else{
                st.push(ch);
            }
            
           
        }
        StringBuilder result = new StringBuilder();
            while(!st.isEmpty()){
                result.append(st.pop());
            }

            return result.reverse().toString();

    }
}