

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // zaroori
        Arrays.sort(s); // zaroori

        int i = 0; // children
        int j = 0; // cookies
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {   // >= hona chahiye
                count++;
                i++;              // next child
                j++;              // next cookie
            } else {
                j++;              // badi cookie try karo
            }
        }

        return count;
    }
}
