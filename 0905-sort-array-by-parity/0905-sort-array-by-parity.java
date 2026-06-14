class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for (int x : nums) {
            if (x % 2 == 0) {
                even.add(x);
            } else {
                odd.add(x);
            }
        }
        
        int[] ans = new int[nums.length];
        int index = 0;
        
        // Pehle saare even elements daale
        for (int i = 0; i < even.size(); i++) {
            ans[index++] = even.get(i);
        }
        // Fir saare odd elements daale
        for (int i = 0; i < odd.size(); i++) {
            ans[index++] = odd.get(i);
        }
        
        return ans;
    }
}