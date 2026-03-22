class Solution {
    public boolean check(int[] arr) {
        int n=arr.length;
        int count=0;
        
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                count++;
            }
        }
        if(count>0){
             if(arr[n-1]>arr[0]){
            return false;
        }
        }
        // If there's more than one "drop", it's not a rotated sorted array
        if(count<=1){
            return true;
        }
        return false;
        
    }
}