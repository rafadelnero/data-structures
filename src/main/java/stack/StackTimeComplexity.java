package stack;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StackTimeComplexity {

    public static void main(String[] args) {
        System.out.println("======= JAVA STACK IMPLEMENTATIONS =======");

        // Demonstrate java.util.Stack
        demonstrateStack();

        // Demonstrate ArrayDeque as Stack
        demonstrateArrayDeque();

        // Demonstrate LinkedList as Stack
        demonstrateLinkedList();
    }

    // java.util.Stack demonstration
    private static void demonstrateStack() {
        System.out.println("\n=== 1. java.util.Stack ===");
        System.out.println("Extends Vector (legacy class), thread-safe but less efficient");

        Stack<Integer> stack = new Stack<>();

        // Push - O(1) amortized
        System.out.println("Push operations (O(1) amortized):");
        long startTime = System.nanoTime();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        long endTime = System.nanoTime();
        System.out.println("  Added 3 elements: " + stack);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Peek - O(1)
        System.out.println("\nPeek operation (O(1)):");
        startTime = System.nanoTime();
        int topValue = stack.peek();
        endTime = System.nanoTime();
        System.out.println("  Top element: " + topValue);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Search - O(n)
        System.out.println("\nSearch operation (O(n)):");
        startTime = System.nanoTime();
        int position = stack.search(20);
        endTime = System.nanoTime();
        System.out.println("  Position of 20: " + position + " (1-based)");
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Size - O(1)
        System.out.println("\nSize operation (O(1)):");
        startTime = System.nanoTime();
        int size = stack.size();
        endTime = System.nanoTime();
        System.out.println("  Size: " + size);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Pop - O(1)
        System.out.println("\nPop operation (O(1)):");
        startTime = System.nanoTime();
        int value = stack.pop();
        endTime = System.nanoTime();
        System.out.println("  Popped value: " + value);
        System.out.println("  Stack after pop: " + stack);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // isEmpty - O(1)
        System.out.println("\nisEmpty operation (O(1)):");
        startTime = System.nanoTime();
        boolean empty = stack.isEmpty();
        endTime = System.nanoTime();
        System.out.println("  Is empty: " + empty);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");
    }

    // ArrayDeque as Stack demonstration
    private static void demonstrateArrayDeque() {
        System.out.println("\n=== 2. java.util.ArrayDeque ===");
        System.out.println("Recommended implementation - efficient and not thread-safe");

        Deque<Integer> stack = new ArrayDeque<>();

        // Push - O(1) amortized
        System.out.println("Push operations (O(1) amortized):");
        long startTime = System.nanoTime();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        long endTime = System.nanoTime();
        System.out.println("  Added 3 elements: " + stack);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Peek - O(1)
        System.out.println("\nPeek operation (O(1)):");
        startTime = System.nanoTime();
        int topValue = stack.peek();
        endTime = System.nanoTime();
        System.out.println("  Top element: " + topValue);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Contains - O(n)
        System.out.println("\nContains operation (O(n)):");
        startTime = System.nanoTime();
        boolean contains = stack.contains(20);
        endTime = System.nanoTime();
        System.out.println("  Contains 20: " + contains);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Size - O(1)
        System.out.println("\nSize operation (O(1)):");
        startTime = System.nanoTime();
        int size = stack.size();
        endTime = System.nanoTime();
        System.out.println("  Size: " + size);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Pop - O(1)
        System.out.println("\nPop operation (O(1)):");
        startTime = System.nanoTime();
        int value = stack.pop();
        endTime = System.nanoTime();
        System.out.println("  Popped value: " + value);
        System.out.println("  Stack after pop: " + stack);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // isEmpty - O(1)
        System.out.println("\nisEmpty operation (O(1)):");
        startTime = System.nanoTime();
        boolean empty = stack.isEmpty();
        endTime = System.nanoTime();
        System.out.println("  Is empty: " + empty);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");
    }

    // LinkedList as Stack demonstration
    private static void demonstrateLinkedList() {
        System.out.println("\n=== 3. java.util.LinkedList ===");
        System.out.println("Alternative implementation with consistent O(1) operations");

        Deque<Integer> stack = new LinkedList<>();

        // Push - O(1)
        System.out.println("Push operations (O(1)):");
        long startTime = System.nanoTime();
        stack.push(10);  // Or stack.addFirst(10)
        stack.push(20);
        stack.push(30);
        long endTime = System.nanoTime();
        System.out.println("  Added 3 elements: " + stack);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Peek - O(1)
        System.out.println("\nPeek operation (O(1)):");
        startTime = System.nanoTime();
        int topValue = stack.peek();  // Or stack.getFirst()
        endTime = System.nanoTime();
        System.out.println("  Top element: " + topValue);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Contains - O(n)
        System.out.println("\nContains operation (O(n)):");
        startTime = System.nanoTime();
        boolean contains = stack.contains(20);
        endTime = System.nanoTime();
        System.out.println("  Contains 20: " + contains);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Size - O(1)
        System.out.println("\nSize operation (O(1)):");
        startTime = System.nanoTime();
        int size = stack.size();
        endTime = System.nanoTime();
        System.out.println("  Size: " + size);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // Pop - O(1)
        System.out.println("\nPop operation (O(1)):");
        startTime = System.nanoTime();
        int value = stack.pop();  // Or stack.removeFirst()
        endTime = System.nanoTime();
        System.out.println("  Popped value: " + value);
        System.out.println("  Stack after pop: " + stack);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");

        // isEmpty - O(1)
        System.out.println("\nisEmpty operation (O(1)):");
        startTime = System.nanoTime();
        boolean empty = stack.isEmpty();
        endTime = System.nanoTime();
        System.out.println("  Is empty: " + empty);
        System.out.println("  Time taken: " + (endTime - startTime) + " ns");
    }

}
