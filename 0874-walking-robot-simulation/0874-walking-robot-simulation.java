class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 1. Obstacles ko Set mein daalo fast lookup ke liye
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        // 2. Directions: North, East, South, West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0, maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) { // Right turn
                d = (d + 1) % 4;
            } else if (cmd == -2) { // Left turn
                d = (d + 3) % 4;
            } else { // Move forward
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];
                    
                    // Obstacle check
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDist = Math.max(maxDist, x*x + y*y);
                    } else {
                        break; // Ruk jao agar raste mein obstacle hai
                    }
                }
            }
        }
        return maxDist;
    }
}