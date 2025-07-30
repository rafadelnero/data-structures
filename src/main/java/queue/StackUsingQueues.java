package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 * This problem tests the ability to understand and manipulate
 * data structures by implementing a stack, which follows Last In, First Out (LIFO) order,
 * using queues which follow FIFO order.
 */
public class StackUsingQueues {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // Always push to the empty queue (queue2)
        queue2.add(x);

        // Push all elements of queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the names of the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());    // returns 2
        System.out.println(stack.pop());    // returns 2
        System.out.println(stack.empty());  // returns false
    }
}