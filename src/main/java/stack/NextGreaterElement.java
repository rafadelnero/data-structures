package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Next Greater Element
 * Problem: Given an array, find the Next Greater Element (NGE) for every element.
 * The NGE for an element x is the first greater element on the right side of x.
 * If no greater element exists, output -1.
 */
public class NextGreaterElement {
    
    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        // Stores indexes from elements that we didn't still find the right greater element
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Initialize result array with -1 (default when no NGE exists)
        Arrays.fill(result, -1);
        
        // Process all elements from left to right
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is greater than stack's top element
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // Set the current element as the NGE for the element at stack's top
                result[stack.pop()] = arr[i];
            }
            
            // Push current index to stack
            stack.push(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases with simplified output
        int[][] testArrays = {
            {4, 5, 2, 25},
            {13, 7, 6, 12}
        };
        
        for (int[] arr : testArrays) {
            int[] result = findNextGreaterElements(arr);
            System.out.println("Input: " + Arrays.toString(arr));
            System.out.println("Output: " + Arrays.toString(result));
            System.out.println();
        }
    }
}