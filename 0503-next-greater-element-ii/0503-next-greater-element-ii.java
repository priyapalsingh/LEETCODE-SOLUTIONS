class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            int ind=i%n;
            int currelement=nums[ind];
            while( !st.empty() && st.peek()<=currelement){
                st.pop();
            }
                
            if(i<n){
               nge[ind]= st.empty() ? -1:st.peek();
            }
            st.push(currelement);
            
        }
        return nge;
        
    }
}