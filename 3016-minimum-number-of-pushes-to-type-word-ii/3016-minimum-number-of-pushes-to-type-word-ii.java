class Solution {
    public int minimumPushes(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int distinctChar=0;
        int pushes=0;
        for(int i=25;i>=0;i--){
            //agar 0 aagya to mtlb aage bhi saare 0 hee honge kyuki sorted array ko peeche se traverse krrhe hai 
            if(freq[i]==0) break;

            pushes+=freq[i]*((distinctChar/8)+1); //0-7 wale number 1 push lenge because we have 8 active keys
            /* manlo 2 freq hai and distinct char abhi 3rd hai 2*(3/8 +1)= 2*(0+1) */
            //ek character press hogya jitni baar it appeared so we track it
            distinctChar++;
        } 
        return pushes;      


    }
}