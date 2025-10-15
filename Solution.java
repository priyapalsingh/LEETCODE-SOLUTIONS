import java.util.*;  
import java.io.*;  
import java.util.ArrayList;

public class Solution {
    
    // Function to reverse array after index m
    public static void reverseArray(ArrayList<Integer> arr, int m) {
        if (m < 0 || m >= arr.size()) {
            return;
        }
        int start = m + 1;
        int end = arr.size() - 1;

        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);

            start++;
            end--;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: size of array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        // Input: elements of array
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Input: index m
        System.out.print("Enter index m: ");
        int m = sc.nextInt();

        // Call function
        reverseArray(arr, m);

        // Print result
        System.out.println("Array after reversing elements after index " + m + ":");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

