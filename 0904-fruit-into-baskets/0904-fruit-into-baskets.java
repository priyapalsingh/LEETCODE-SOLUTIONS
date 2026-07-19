class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        Map<Integer,Integer> basket=new HashMap<>();
        int left=0;
        int maxfruits=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           basket.put(fruits[i],basket.getOrDefault(fruits[i],0)+1);

           while(basket.size()>2){
            //basket size exceeded remove from left
            int leftfruit=fruits[left];
            basket.put(leftfruit,basket.get(leftfruit)-1);

            //if left fruit gets finished then just remove it
            if(basket.get(leftfruit)==0){
                basket.remove(leftfruit);
            }
            left++;
           }
           maxfruits=Math.max(maxfruits,i-left+1);
           
        }
        return maxfruits;
        
    }
}