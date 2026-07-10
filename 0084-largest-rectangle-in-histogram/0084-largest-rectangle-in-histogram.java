import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        
        int[] right = new int[n]; // array jo next least element ka track rakhega 
        int[] left = new int[n];  // array jo previous least element ka track rakhega 

        // 1. Right side next smaller element nikalna
        for (int i = n - 1; i >= 0; i--) {
            // FIX: Stack ke top par agar bada element hai, toh use pop karo
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // Agar stack khali ho gaya, matlab right mein koi chota element nahi hai
            // Toh boundary array ke bahar (n) hogi
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Stack ko khali karo taaki left ke liye dobara use kar sakein
        st.clear();

        // 2. Left side previous smaller element nikalna
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // Agar stack khali ho gaya, matlab left mein koi chota element nahi hai
            // Toh boundary array ke pehle (-1) hogi
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // 3. Max Area Calculate karna
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // Width = Right boundary index - Left boundary index - 1
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}