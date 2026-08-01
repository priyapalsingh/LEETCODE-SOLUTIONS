class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        //agar player 1 ko jeetna hai to for score1-score2 ko maximize krna chahega
        return solve(nums,0,n-1)>=0;

    }
    //agar player1 nums[i] select krega to player2 ko nums[i+1] or nums[j] mei se kuch select krna pdega
    //and same goes if wo nums[j] select krega to ab usne jo bhi pick kia or jo player2 ke liye option bacha usme se max diff kisme ayega wo select krenge hum 
    //and at the end agar wo score diff >=0 hai to mtlb player 1 won
    private int solve(int[] nums,int i,int j){
        int n=nums.length;
        if(i==j){
            return nums[i];
        }
        int pickLeft=nums[i] - solve(nums,i+1,j);
        int pickRight=nums[j] - solve(nums,i,j-1);

        return Math.max(pickLeft,pickRight);
    }
}