import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Map to store list1 elements and their corresponding indices
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        
        // Traverse list2 to find common elements
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int i = map.get(list2[j]);
                int sum = i + j; // Calculate index sum
                
                // If a smaller index sum is found, clear the old results
                if (sum < minSum) {
                    minSum = sum;
                    res.clear(); 
                    res.add(list2[j]);
                } 
                // If it matches the current minimum sum, add to the results
                else if (sum == minSum) {
                    res.add(list2[j]);
                }
            }
        }
        
        // Convert the ArrayList back to a String[] array and return
        return res.toArray(new String[0]);
    }
}