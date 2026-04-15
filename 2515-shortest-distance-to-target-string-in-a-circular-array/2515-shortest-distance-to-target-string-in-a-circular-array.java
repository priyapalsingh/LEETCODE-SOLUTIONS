class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                // 1. Direct distance nikal lo
                int directDist = Math.abs(i - startIndex);
                
                // 2. Circular distance (baaki bacha hua raasta)
                int circularDist = n - directDist;
                
                // In dono mein se jo minimum ho, use update karo
                int currentShortest = Math.min(directDist, circularDist);
                minDistance = Math.min(minDistance, currentShortest);
            }
        }

        // Agar minDistance update nahi hua, matlab target nahi mila
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}