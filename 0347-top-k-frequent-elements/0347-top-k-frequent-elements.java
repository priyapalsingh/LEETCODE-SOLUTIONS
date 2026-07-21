class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
       HashMap<Integer,Integer> freq=new HashMap<>();
       for(int i: nums){
           freq.put(i,freq.getOrDefault(i,0)+1);
        }

        //hum ek aisi list bnanege jisme n listes hongi and each list at i represents the number 
        //in nums which has a frequency of i 
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());

        }
        //maanlo agar numsmei 2 hai jo 4 baar aaya hai to list mei 4th index par jakr 2 add krdo 
        for(int key:freq.keySet()){
            int count=freq.get(key);
            //numbers ko unki frequency number par daalo
            list.get(count).add(key);
        }

        int result[]=new int[k];
        int counter=0;
        for(int i=list.size()-1;i>=0 && counter<k ; i--){
            for(int num:list.get(i)){
                result[counter]=num;
                counter++;
                if(counter==k){
                    break;
                }
            }
        }
        return result;
    }
}