class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
       int n=arr.length;
       Map<Integer,Integer> map=new HashMap<>();
       map.put(0,-1);
       int runningsum=0;
       for(int i=0;i<n;i++){
        runningsum+=arr[i];
        int runningrem=runningsum%k;

        if(map.containsKey(runningrem)){
            //check for length
            if(i-map.get(runningrem) >=2 ){
                return true;
            } 
        }else{
            map.put(runningrem,i);
        }
       }
       return false;
    }
}