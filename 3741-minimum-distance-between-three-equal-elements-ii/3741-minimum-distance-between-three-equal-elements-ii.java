class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        boolean found=false;
         int minDistance=Integer.MAX_VALUE;
         
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            
                map.get(nums[i]).add(i);
            
           List<Integer> indices=map.get(nums[i]);
           if(indices.size()>=3){
            found =true;
            int first=indices.get(indices.size()-3);
            int last=indices.get(indices.size()-1);

            int currDistance=2*(last-first);
            minDistance=Math.min(minDistance,currDistance);
           }
        }
        return found ? minDistance : -1;
        
    }
}