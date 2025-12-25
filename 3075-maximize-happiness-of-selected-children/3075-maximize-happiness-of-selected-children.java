class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long smiles=0;
        int n=happiness.length;
        Arrays.sort(happiness);
        long alreadyDecreased=0;
        
        for(int i=n-1 ; i>=0 && k>0 ; i--,k--){
            long current=happiness[i]-alreadyDecreased;
            if(current<=0) break;
            smiles+=current;
            alreadyDecreased++;
        }
        return smiles;
    }
}