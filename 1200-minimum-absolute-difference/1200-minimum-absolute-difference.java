class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        int mindiff=Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n-1;i++){
           int diff=arr[i+1]-arr[i];
           mindiff=Math.min(diff,mindiff);
        }
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]==mindiff){
                list.add(new ArrayList<>(List.of(arr[i],arr[i+1])));
            }
        }
        return list;
        
    }
}