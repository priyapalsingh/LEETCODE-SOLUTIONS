class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int totalWeight = 0;
            // Word ke har character ka weight sum karna
            for (char c : word.toCharArray()) {
                totalWeight += weights[c - 'a'];
            }
            
            // Modulo 26 le kar 'z' se reverse map karna
            char mappedChar = (char) ('z' - (totalWeight % 26));
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}