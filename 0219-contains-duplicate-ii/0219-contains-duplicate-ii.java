class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(i>=k){/*agar hum element add krhe hai or humara window size k se bda hogya to piche wala 
            hata do kyuki ab hume uska kaam nahi hai  */
                set.remove(nums[i-k]);
            }
            if(!set.add(nums[i])){ /* agar add nahi hoparha mtlb set mei already 
            waisa element hai that means duplicate hai */ 
                return true;
            }
        }
        return false;
        
    }
}