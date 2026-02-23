import java.util.*;

class Solution {
    class Pair implements Comparable<Pair>{
        String video;
        int val;
        Pair(String video,int val){
            this.video=video;
            this.val=val;
        }
        
        public int compareTo(Pair other){
            if(this.val!=other.val){
                return this.val-other.val;  // Frequency ascending
            }
            return this.video.compareTo(other.video);  // Alphabetical
        }
    }
    
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> qu=new LinkedList<>();
        List<Integer> visited=new ArrayList<>();
        qu.offer(id);
        visited.add(id);
        
        int currentLevel=0;
        while(!qu.isEmpty() && currentLevel<level){
            int size=qu.size();
            for(int i=0;i<size;i++){
                int currId=qu.poll();
                for(int friend:friends[currId]){
                    if(!visited.contains(friend)){
                        visited.add(friend);
                        qu.offer(friend);
                    }
                }
            }
            currentLevel++;
        }
        
        // ✅ FIX: Queue se exact level ke friends ke videos lo
        HashMap<String,Integer> map=new HashMap<>();
        while(!qu.isEmpty()){
            int currId=qu.poll();
            for(String video:watchedVideos.get(currId)){
                map.put(video,map.getOrDefault(video,0)+1);
            }
        }
        
        List<Pair> videoList=new ArrayList<>();
        for(String video:map.keySet()){
            videoList.add(new Pair(video,map.get(video)));
        }
        Collections.sort(videoList);
        
        List<String> res=new ArrayList<>();
        for(Pair ans:videoList){
            res.add(ans.video);
        }
        return res;
    }
}

