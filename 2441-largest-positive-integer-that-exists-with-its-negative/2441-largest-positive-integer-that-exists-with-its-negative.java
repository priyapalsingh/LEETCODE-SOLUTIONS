class Solution {
    public int findMaxK(int[] nums) {
        int posmax=0;
        Set<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            if(set.contains(-nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}