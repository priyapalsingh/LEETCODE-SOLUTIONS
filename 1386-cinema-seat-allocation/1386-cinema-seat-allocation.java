import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Har row ki reserved seats (2 se 9) ko bitmask me store karo
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Seats 1 aur 10 kisi 4-person group ka part nahi ban sakti
            if (col >= 2 && col <= 9) {
                // col ke index ko 0-7 bit range me shift karo (seat 2 -> bit 0, seat 9 -> bit 7)
                int bit = 1 << (col - 2);
                map.put(row, map.getOrDefault(row, 0) | bit);
            }
        }

        // Jin rows me koi reservation nahi hai, unme direct 2 groups baith sakte hain
        int totalGroups = (n - map.size()) * 2;

        // Bitmasks for valid segments:
        // Left:   seats 2,3,4,5 -> bits 0,1,2,3 -> 0b00001111 (15)
        // Right:  seats 6,7,8,9 -> bits 4,5,6,7 -> 0b11110000 (240)
        // Middle: seats 4,5,6,7 -> bits 2,3,4,5 -> 0b00111100 (60)
        int leftMask = 0b00001111;
        int rightMask = 0b11110000;
        int middleMask = 0b00111100;

        for (int reserved : map.values()) {
            boolean canLeft = (reserved & leftMask) == 0;
            boolean canRight = (reserved & rightMask) == 0;
            boolean canMiddle = (reserved & middleMask) == 0;

            if (canLeft && canRight) {
                totalGroups += 2;
            } else if (canLeft || canRight || canMiddle) {
                totalGroups += 1;
            }
        }

        return totalGroups;
    }
}