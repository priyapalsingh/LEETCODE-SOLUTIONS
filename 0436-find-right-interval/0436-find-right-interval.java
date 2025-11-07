class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[][] starts=new int[n][2];
        for(int i=0;i<n;i++){
            starts[i][0]=intervals[i][0];
            starts[i][1]=i;
        }
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result=new int[n];
        Arrays.fill(result,-1);
        for(int i=0;i<n;i++){
            int end=intervals[i][1];
            int index=BinarySearch(starts,end);
            if(index!=-1){
                result[i]=starts[index][1];
            }
        }
        return result;
        
    }
     private int BinarySearch(int[][] arr,int target){
            int start=0;
            int end=arr.length-1;
            int ans=-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid][0]>=target){
                    ans=mid;
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            return ans;
        }
}