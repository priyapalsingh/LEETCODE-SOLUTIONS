class Solution {
    public int ladderLength(String beginword, String endword, List<String> wordlist) {
        Set<String> set=new HashSet<>(wordlist);// directly set mei wordlist aaagyi
        if(!set.contains(endword)) return 0;
        Queue<String> qu=new LinkedList<>();
        if(set.contains(beginword)){
            qu.offer(beginword);
            set.remove(beginword);
        }
        qu.offer(beginword);
        int count=0;
        while(!qu.isEmpty()){
            int level=qu.size();
            for(int i=0;i<level;i++){
                String node=qu.poll();
                if(node.equals(endword)){
                    return count+1;
                }
                List<String> neighbour=getneighbour(node,set);
                for(String word:neighbour){
                    if(set.contains(word)){
                        qu.offer(word);
                        set.remove(word);
                    }
                }
            }
            count++;
        }
        return count;
        

        
    }
    private List<String>  getneighbour(String word,Set<String> set){
        ArrayList<String> neighbour=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                if(ch==word.charAt(i)){
                    continue;
                }
                String newWord=word.substring(0,i)+ch+word.substring(i+1,word.length());
                if(set.contains(newWord)){
                    neighbour.add(newWord);
                }

            }
        }
        return neighbour;
    }
}