class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            String str=String.valueOf(num);
            for(char c:str.toCharArray()){
                list.add(c-'0'); //char to integer
            }
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
        
    }
}