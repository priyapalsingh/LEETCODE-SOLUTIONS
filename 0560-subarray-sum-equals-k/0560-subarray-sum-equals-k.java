class Solution {
    public int subarraySum(int[] arr, int k) {
      int n=arr.length; 
      int currsum=0;
      int count=0;
      Map<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<n;i++){
        currsum+=arr[i];

        if(currsum==k){
            count++;
        }
        if(map.containsKey(currsum-k)){
            count+=map.get(currsum-k);
        }
        map.put(currsum,map.getOrDefault(currsum,0)+1);
      } 
      return count;

    }
}