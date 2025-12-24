class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples=0,boxes=0;
        int totalCapacity=0;
        for(int ap:apple){
            totalApples+=ap;
        }
        Arrays.sort(capacity);
        for(int i=capacity.length-1;i>=0;i--){
            totalCapacity+=capacity[i];
            boxes++;

            if(totalCapacity>=totalApples){
                break;
            }
        }
        return boxes;
        
    }
}