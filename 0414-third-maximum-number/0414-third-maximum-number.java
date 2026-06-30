class Solution {
    public int thirdMax(int[] nums) {
        // Distinct top 3 maximums ko track karne ke liye objects
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        
        for (int num : nums) {
            // Agar number pehle se hi hamare top 3 me hai, toh duplicates skip karo
            if ((firstMax != null && firstMax == num) || 
                (secondMax != null && secondMax == num) || 
                (thirdMax != null && thirdMax == num)) {
                continue;
            }
            
            // 1. Agar current number firstMax se bada hai
            if (firstMax == null || num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } 
            // 2. Agar current number firstMax se chota par secondMax se bada hai
            else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } 
            // 3. Agar current number secondMax se chota par thirdMax se bada hai
            else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }
        
        // Agar third maximum exist nahi karta, toh firstMax (maximum) return karo
        return (thirdMax == null) ? firstMax : thirdMax;
    }
}