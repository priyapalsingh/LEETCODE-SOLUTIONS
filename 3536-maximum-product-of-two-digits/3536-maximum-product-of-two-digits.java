class Solution {
    public int maxProduct(int n) {
        int max1=0;
        int max2=0;
        List<Integer> list=new ArrayList<>();
        while(n>0){
            int digit=n%10;
            list.add(digit);
            n=n/10;
        }
        Collections.sort(list);
        int product=list.get(list.size()-1)*list.get(list.size()-2);
        return product;
    }
}