class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long weight=mass;
        Arrays.sort(asteroids);
        for(int i=0;i<asteroids.length;i++){
            if(weight>=asteroids[i]){
                weight+=asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}