class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                list.add(arr[i]);
            }
            else{
                while( !list.isEmpty() && list.get(list.size() -1)>0 && list.get(list.size() -1)<Math.abs(arr[i])){
                    list.remove(list.size() -1);
                }
                if(!list.isEmpty() && list.get(list.size() -1)==Math.abs(arr[i])){
                    list.remove(list.size() -1);
                }
                else if( list.isEmpty() || list.get(list.size()-1)<0 ){
                    list.add(arr[i]);
                }
            } 
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
            
        }
        return result;
        
    }
}