package queue;

import java.util.*;
import java.util.concurrent.*;

public class QueueTimeComplexity {
    
    public static void main(String[] args) {
        // Standard Queue implementations
        demonstrateLinkedList();
        demonstrateArrayDeque();
        
        // Priority Queue
        demonstratePriorityQueue();
        
        // Concurrent Queue implementations
        demonstrateConcurrentLinkedQueue();
        demonstrateLinkedBlockingQueue();
    }

    /**
     * Implements: Queue and Deque interfaces
     * Operations: offer/poll/peek all O(1)
     * Structure: Doubly-linked list (works as a stack and queue)
     * Advantages: Dynamic size, efficient insertions/removals at both ends
     * Disadvantages: More memory overhead than array-based queues
     * Best use: When frequently adding/removing from both ends
     * Performance: Fast operations, but slower than ArrayDeque for most queue operations
     * Implementation: Each element stored in a Node with prev/next pointers
     * Thread safety: Not thread-safe, use Collections.synchronizedList() if needed
     */
    private static void demonstrateLinkedList() {
        System.out.println("\n=== LinkedList as Queue ===");
        Queue<Integer> queue = new LinkedList<>();
        
        // offer: O(1) - adds to the end of the linked list
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("After offers: " + queue);
        
        // peek: O(1) - returns the head element without removing
        System.out.println("Peek: " + queue.peek());
        
        // poll: O(1) - removes and returns the head element
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);
        
        // size: O(1) - LinkedList maintains a size counter
        System.out.println("Size: " + queue.size());
        
        // isEmpty: O(1) - checks if size is 0
        System.out.println("Is empty: " + queue.isEmpty());
    }

    /**
     * Implements Deque interface with O(1) amortized time for all queue operations
     * Based on resizable circular array implementation
     * More memory-efficient than LinkedList (no per-element node overhead)
     * Better performance due to improved cache locality
     * Can function as both stack (LIFO) and queue (FIFO)
     * Not thread-safe (use concurrency wrappers if needed)
     * Cannot contain null elements
     * Faster than Stack and LinkedList for most operations
     * Automatically resizes when capacity is reached (doubles in size)
     * No support for random access or indexed operations
     * Maintains head and tail indices for efficient operations at both ends
     * Recommended default choice for stack and queue implementations
     */
    private static void demonstrateArrayDeque() {
        System.out.println("\n=== ArrayDeque as Queue ===");
        Queue<Integer> queue = new ArrayDeque<>();
        
        // offer: O(1) amortized - may need to resize array occasionally
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("After offers: " + queue);
        
        // peek: O(1) - returns the head element without removing
        System.out.println("Peek: " + queue.peek());
        
        // poll: O(1) - removes and returns the head element
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);
        
        // size: O(1) - ArrayDeque maintains a size counter
        System.out.println("Size: " + queue.size());
        
        // isEmpty: O(1) - checks if size is 0
        System.out.println("Is empty: " + queue.isEmpty());
    }

    /**
     * Priority-based queue implementation (not FIFO)
     * Elements ordered by natural ordering or custom Comparator
     * O(log n) for insertion/removal, O(1) for peek operations
     * Default is min-heap (smallest element first)
     * Not thread-safe and cannot contain null elements
     * Backed by binary heap implementation
     * Ideal for algorithms requiring priority ordering (Dijkstra's, etc.)
     */
    private static void demonstratePriorityQueue() {
        System.out.println("\n=== PriorityQueue ===");
        // Min heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // offer: O(log n) - needs to maintain heap property
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println("After offers: " + pq); // Note: toString doesn't guarantee order
        
        // peek: O(1) - returns the minimum element
        System.out.println("Peek (min element): " + pq.peek());
        
        // poll: O(log n) - removes min element and restores heap
        System.out.println("Poll (min element): " + pq.poll());
        System.out.println("After poll: " + pq);
        
        // size: O(1) - maintains counter
        System.out.println("Size: " + pq.size());
    }

    /**
     * Thread-safe non-blocking queue using Michael-Scott algorithm
     * High-performance implementation using CAS (Compare-and-Swap) operations instead of locks
     * O(1) time complexity for offer(), poll(), and peek()
     * Unbounded capacity with no blocking behavior
     * Higher throughput than synchronized collections for concurrent access
     * No constant-time size() method (requires full traversal)
     * Cannot contain null elements
     * Suitable for scenarios requiring high concurrency without blocking
     * Lower latency than lock-based alternatives
     * Weakly consistent iterators
     */
    private static void demonstrateConcurrentLinkedQueue() {
        System.out.println("\n=== ConcurrentLinkedQueue ===");
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        
        // offer: O(1) - lock-free algorithm
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("After offers: " + queue);
        
        // peek: O(1) - returns the head element
        System.out.println("Peek: " + queue.peek());
        
        // poll: O(1) - removes and returns the head element
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);
        
        // size: O(n) - must traverse the entire queue!
        System.out.println("Size (traverses all elements): " + queue.size());
        
        // isEmpty: O(1) - only checks the head
        System.out.println("Is empty: " + queue.isEmpty());
    }

    /**
     * Thread-safe FIFO queue that blocks when full/empty
     * Two-lock design (separate head/tail locks) for higher throughput
     * Optionally bounded capacity with blocking operations
     * O(1) operations including accurate size() method
     * Ideal for producer-consumer patterns with blocking semantics
     * More efficient than single-lock alternatives for concurrent access
     * Supports both timed and untimed blocking operations
     */
    private static void demonstrateLinkedBlockingQueue() {
        System.out.println("\n=== LinkedBlockingQueue ===");
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        
        // offer: O(1) - adds to tail of linked list
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("After offers: " + queue);
        
        try {
            // put: O(1) - blocks if queue is full (unbounded by default)
            queue.put(40);
            System.out.println("After put: " + queue);
            
            // peek: O(1) - returns head element
            System.out.println("Peek: " + queue.peek());
            
            // take: O(1) - blocks if queue is empty
            System.out.println("Take: " + queue.take());
            System.out.println("After take: " + queue);
            
            // poll with timeout: O(1) but may block up to timeout
            System.out.println("Poll with timeout: " + 
                queue.poll(100, TimeUnit.MILLISECONDS));
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while waiting");
        }
        
        // size: O(1) - maintains counter
        System.out.println("Size: " + queue.size());
        
        // drainTo: O(n) - efficiently removes elements to another collection
        List<Integer> list = new ArrayList<>();
        queue.drainTo(list);
        System.out.println("Drained to list: " + list);
        System.out.println("Queue after drain: " + queue);
    }
}