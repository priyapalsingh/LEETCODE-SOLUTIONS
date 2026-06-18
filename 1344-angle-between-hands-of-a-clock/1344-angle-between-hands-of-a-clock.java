class Solution {
    public double angleClock(int hour, int minutes) {
        // 1. Minute hand ka angle nikal lo (1 min = 6 degrees)
        double minuteAngle = minutes * 6.0;
        
        // 2. Hour hand ka angle nikal lo (1 hour = 30 degrees, 1 min = 0.5 degree)
        // hour % 12 isliye taaki 12 baje ko hum 0 degree maane
        double hourAngle = ((hour % 12) * 30.0) + (minutes * 0.5);
        
        // 3. Dono hands ke beech ka absolute difference nikal lo
        double diff = Math.abs(hourAngle - minuteAngle);
        
        // 4. Agar angle 180 se bada hai, toh smaller angle ke liye 360 se minus karo
        if (diff > 180.0) {
            return 360.0 - diff;
        }
        
        return diff;
    }
}