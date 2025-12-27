class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] small= nums1.length <= nums2.length ? nums1:nums2;
        int[] large= nums1.length >= nums2.length ? nums1:nums2;

        Map<Integer, Integer> freq = new HashMap<>();
        for(int x:small){
            freq.put(x,freq.getOrDefault(x,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for (int x : large) {
            int count = freq.getOrDefault(x, 0);
            if (count > 0) {
               res.add(x);
               freq.put(x, count - 1);
            }
        }
        // Convert list to array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
        
    }
}