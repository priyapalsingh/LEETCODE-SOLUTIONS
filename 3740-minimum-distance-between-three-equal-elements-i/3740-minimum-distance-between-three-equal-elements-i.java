class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        int minDistance=Integer.MAX_VALUE;
        boolean found=false;
        Map<Integer , List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        
        List<Integer> indices=map.get(nums[i]);
        if(indices.size()>=3){
            found=true;
            int first=indices.get(indices.size()-3);
            int last=indices.get(indices.size()-1);

            int currDistance=2*(last-first);
            minDistance=Math.min(currDistance,minDistance);
        }
        }
        return found ? minDistance:-1;

       
        
    }
    
}