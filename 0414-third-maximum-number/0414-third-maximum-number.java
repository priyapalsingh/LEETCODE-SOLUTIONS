class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int x:nums){
            if(!list.contains(x)){
                list.add(x);
            }
        }
        Collections.sort(list);
        if(list.size()<=2){
            return list.get(list.size()-1);
        }
        return list.get(list.size()-3);
    }
}