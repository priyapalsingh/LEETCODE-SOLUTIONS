class Solution {
    public int distributeCandies(int[] arr) {
        sort(arr);
        int n=arr.length;
        Set<Integer> hash=new HashSet<>();
        for(int i=n-1;i>=0;i--){
            hash.add(arr[i]);
            if(hash.size()==n/2){
                break;
            }
        }
        return hash.size();
    }
    private int[] sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
           if(arr[i]>arr[i+1]){
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
           } 
        }
        return arr;
    }
}