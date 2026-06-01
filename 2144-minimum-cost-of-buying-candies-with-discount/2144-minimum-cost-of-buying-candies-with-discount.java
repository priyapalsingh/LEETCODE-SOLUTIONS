class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int price=0;
        for(int i=cost.length-1 ; i>=0 ; i-=3){
            //i-=3 ka mtlb hai i ek lene ke aad 3 elements ke baad par jump krega 
           
            price+=cost[i];
            // Agar group mein dusra element bhi exist karta hai, toh use bhi add karo
            if (i - 1 >= 0) {
                price += cost[i - 1];
            }
            // i - 2 wala element (teesra sabse sasta) loop ke `i -= 3` 
            // ki wajah se apne aap skip ho jayega!
        }
        return price;
    }
}