class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String key:map.keySet()){
            list.add(key);
        }
        // 3. Custom Sorting Logic
        Collections.sort(list, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            // Agar frequency alag hai, toh higher frequency pehle aaye (descending)
            if (freqA != freqB) {
                return freqB - freqA;
            }
            // Agar frequency same hai, toh lexicographically pehle aane wala word pehle aaye (ascending)
            return a.compareTo(b);
        });

        return list.subList(0, k);
    }
}