package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapComplexity {
    
    public static void main(String[] args) {
        // Initialize a HashMap
        Map<String, Integer> map = new HashMap<>();
        
        // ========== INSERTION OPERATIONS ==========
        
        // put() - O(1) average time complexity
        // In the worst case (many collisions), it could be O(n)
        map.put("key1", 10);          // O(1) average
        map.put("key2", 20);          // O(1) average
        
        // putIfAbsent() - O(1) average time complexity
        // Only inserts if key is not present
        map.putIfAbsent("key3", 30);  // O(1) average
        
        // ========== LOOKUP OPERATIONS ==========
        
        // get() - O(1) average time complexity
        // In the worst case (many collisions), it could be O(n)
        int value = map.get("key1");  // O(1) average
        
        // getOrDefault() - O(1) average time complexity
        int valueOrDefault = map.getOrDefault("nonExistentKey", 0);  // O(1) average
        
        // containsKey() - O(1) average time complexity
        boolean hasKey = map.containsKey("key2");  // O(1) average
        
        // containsValue() - O(n) time complexity
        // Must iterate through all entries to find a value
        boolean hasValue = map.containsValue(20);  // O(n)
        
        // ========== DELETION OPERATIONS ==========
        
        // remove() - O(1) average time complexity
        map.remove("key1");  // O(1) average
        
        // ========== ITERATION OPERATIONS ==========
        
        // keySet(), values(), entrySet() - O(1) to get the view
        // O(n) to iterate through all elements
        
        // Iterating through all keys - O(n)
        for (String key : map.keySet()) {  // O(n) total
            // Process each key
        }
        
        // Iterating through all values - O(n)
        for (Integer val : map.values()) {  // O(n) total
            // Process each value
        }
        
        // Iterating through all entries - O(n)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  // O(n) total
            String key = entry.getKey();    // O(1)
            Integer val = entry.getValue(); // O(1)
            // Process each entry
        }
        
        // ========== BULK OPERATIONS ==========
        
        // putAll() - O(m) where m is the size of the map being added
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("key4", 40);
        anotherMap.put("key5", 50);
        map.putAll(anotherMap);  // O(m) where m is the size of anotherMap
        
        // clear() - O(n) where n is the size of the map
        map.clear();  // O(n)
        
        // ========== SIZE OPERATIONS ==========
        
        // size() - O(1)
        int size = map.size();  // O(1)
        
        // isEmpty() - O(1)
        boolean empty = map.isEmpty();  // O(1)
    }
    
    // ========== HASH COLLISION DEMONSTRATION ==========
    
    // Example to demonstrate O(n) worst case due to hash collisions
    public static void demonstrateCollisions() {
        // Create a HashMap with objects that all hash to the same bucket
        Map<BadHashObject, Integer> collisionMap = new HashMap<>();
        
        // Adding n elements all hashing to the same bucket - O(n²) total time
        // Each insertion becomes O(n) as the linked list or tree grows
        for (int i = 0; i < 1000; i++) {
            collisionMap.put(new BadHashObject(i), i);  // Each put is O(i) in worst case
        }
        
        // Lookup in worst case - O(n)
        collisionMap.get(new BadHashObject(500));  // O(n) in worst case with collisions
    }
    
    // Class with poor hash function that causes collisions
    static class BadHashObject {
        private int value;
        
        public BadHashObject(int value) {
            this.value = value;
        }
        
        @Override
        public int hashCode() {
            // Bad hash function that causes all objects to hash to the same bucket
            return 1; // All objects return the same hash code
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BadHashObject that = (BadHashObject) obj;
            return value == that.value;
        }
    }
    
    // ========== SPACE COMPLEXITY ==========
    
    // The space complexity of a HashMap is O(n) where n is the number of key-value pairs
    public static void spaceComplexity() {
        Map<Integer, String> map = new HashMap<>();
        
        // Adding n elements requires O(n) space
        for (int i = 0; i < 1000; i++) {
            map.put(i, "Value" + i);  // Total space grows linearly with number of entries
        }
        
        // Internal HashMap implementation typically allocates more space than needed
        // to maintain a low load factor (usually around 0.75), so actual space used
        // might be approximately 1.33 * n for n elements
    }
}