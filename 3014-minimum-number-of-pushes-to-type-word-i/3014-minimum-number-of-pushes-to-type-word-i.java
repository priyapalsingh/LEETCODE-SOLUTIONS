class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int pushes=0;
        //for first 8 char one push kyuki 2 se 9 mei pehle position pr daldenge
        if(n>0) pushes+=Math.min(n,8)*1;
        // Next 8 characters (index 8 to 15) take 2 pushes each
        if (n > 8) pushes += Math.min(n - 8, 8) * 2;

        // Next 8 characters (index 16 to 23) take 3 pushes each
        if (n > 16) pushes += Math.min(n - 16, 8) * 3;

        // Remaining characters (index 24 to 25) take 4 pushes each
        if (n > 24) pushes += (n - 24) * 4;

        return pushes;
    }
}