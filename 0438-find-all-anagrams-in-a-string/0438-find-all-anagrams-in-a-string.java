class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        ArrayList<Integer> result=new ArrayList<>();
        if(slen<plen){
            return result;
        }


        int[] pcount=new int[26];
        int[] scount=new int[26];
        for(int i=0;i<plen;i++){
            pcount[p.charAt(i)-'a']++;
            scount[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pcount,scount)){
            result.add(0);
        }
        for(int i=plen;i<slen;i++){
            scount[s.charAt(i)-'a']++;
            scount[s.charAt(i-plen)-'a']--;

            if(Arrays.equals(pcount,scount)){
                result.add(i-plen+1);
            }

        }
        return result;
    }
}