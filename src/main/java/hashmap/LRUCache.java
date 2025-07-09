package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    // Node class for doubly linked list
    class Node {
        K key;
        V value;
        Node prev;
        Node next;
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<K, Node> cache;
    private Node head; // Most recently used
    private Node tail; // Least recently used
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) {
            return null; // Key doesn't exist
        }
        
        // Move to front (most recently used)
        removeNode(node);
        addToFront(node);
        
        return node.value;
    }
    
    public void put(K key, V value) {
        // Check if key already exists
        Node node = cache.get(key);
        
        if (node != null) {
            // Update existing value
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            // Create new node
            Node newNode = new Node(key, value);
            
            // Check if cache is full
            if (cache.size() >= capacity) {
                // Remove least recently used item (from tail)
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            
            // Add new node
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }
    
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int size() {
        return cache.size();
    }
}