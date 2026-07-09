class Solution {
    public int majorityElement(int[] v) {
        int el=0;
        int cnt=0;
        int n=v.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(v[i],map.getOrDefault(v[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>n/2){
                return entry.getKey();
            }

        }
        return -1;
    }
}