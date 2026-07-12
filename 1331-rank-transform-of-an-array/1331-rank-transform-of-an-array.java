class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int[] nums=new int[arr.length];
       for(int i=0;i<arr.length;i++){
        nums[i]=arr[i];
       } 
       Map<Integer,Integer> map=new HashMap<>();
       Arrays.sort(nums);
       int currRank=1;
       for(int i=0;i<nums.length;i++){
        if(!map.containsKey(nums[i])){
            map.put(nums[i],currRank);
            currRank++;
        }else{
            continue;
        }
        
       }
       int[] rank=new int[arr.length];
       for(int i=0;i<arr.length;i++){
        rank[i]=map.get(arr[i]);
       }
       return rank;       
    }
}