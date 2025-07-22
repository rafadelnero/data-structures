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
}