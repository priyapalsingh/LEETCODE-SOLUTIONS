class Solution {
    public int subarraySum(int[] arr, int k) {
      int n=arr.length; 
      int currsum=0;
      int count=0;
      for(int i=0;i<n;i++){
         currsum=0;
        for(int j=i;j<n;j++){
            currsum+=arr[j];
            if(currsum==k){
                count++;
            }
        }
      }
      return count;

    }
}