package queue;

import java.util.NoSuchElementException;
import java.util.Stack;

class QueueUsingTwoStacks<T> {
    private Stack<T> stack1; // for enqueue
    private Stack<T> stack2; // for dequeue
    
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Add element to the queue
    public void enqueue(T data) {
        stack1.push(data);
    }
    
    // Remove element from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    
    // View the front element without removing
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

        // Enqueue elements
        System.out.println("Enqueuing elements: 1, 2, 3, 4, 5");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.peek());

        // Dequeue elements
        System.out.println("\nDequeuing elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("\nQueue is empty: " + queue.isEmpty());

        // Testing exception handling
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Test with more elements
        System.out.println("\nEnqueuing more elements: 10, 20, 30");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Enqueuing: 40, 50");
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("\nDequeuing remaining elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    public int size() {
        return stack1.size() + stack2.size();
    }
}