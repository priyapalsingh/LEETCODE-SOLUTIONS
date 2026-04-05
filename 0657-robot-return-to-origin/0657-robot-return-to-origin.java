class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        int n = moves.length();
        
        for (int i = 0; i < n; i++) {
            char move = moves.charAt(i);
            
            // Note: Moves are Uppercase 'U', 'D', 'L', 'R'
            if (move == 'U') {
                v++;
            } else if (move == 'D') {
                v--;
            } else if (move == 'L') {
                h--;
            } else if (move == 'R') {
                h++;
            }
        }
        
        // Returns true only if the robot is back at (0,0)
        return h == 0 && v == 0;
    }
}