class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long sum=0;
        int[] nse=findnse(arr);
        int[] pse=findpse(arr);
        int mod=1000000007;
        for(int i=0;i<n;i++){
            long left=(long)i-pse[i];
            long right=nse[i]-(long)i;
            long freq=(long)left*right;
            long contribution= ((long)arr[i]*freq)%mod;
            sum= (sum+contribution)%mod;
        }
        return (int)sum;
        
      
        
    }
     private int[] findnse(int[] arr){
            int n=arr.length;
            Stack<Integer> st=new Stack<>();
            int[] ans=new int[n];
            for(int i=n-1;i>=0;i--){
                while(!st.empty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                ans[i]= !st.empty()?st.peek():n;
                st.push(i);
            }
            return ans;
        }
    private int[] findpse(int[] arr){
            int n=arr.length;
            Stack<Integer> st=new Stack<>();
            int[] ans=new int[n];
            for(int i=0;i<n;i++){
                while(!st.empty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                ans[i]= !st.empty()?st.peek():-1;
                st.push(i);
            }
            return ans;
    }
}