package graph;

import java.util.*;

public class GraphPathFinder {
    
    // Adjacency list representation of the graph
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    
    // Adds an edge to the graph
    public void addEdge(int source, int destination) {
        // Adds edge from source to destination
        graph.putIfAbsent(source, new ArrayList<>());
        graph.get(source).add(destination);
        
        // Adds edge from destination to source (for undirected graph)
        graph.putIfAbsent(destination, new ArrayList<>());
        graph.get(destination).add(source);
    }
    
    // Checks if path exists between source and destination
    public boolean hasPath(int source, int destination) {
        // If source and destination are the same, path exists
        if (source == destination) return true;
        
        // If source or destination not in graph, no path exists
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            return false;
        }
        
        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        
        // BFS to find path
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // Check all neighbors of current node
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (neighbor == destination) {
                    return true; // Path found
                }
                
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        // No path found after exploring all reachable nodes
        return false;
    }
    
    // Example usage
    public static void main(String[] args) {
        GraphPathFinder g = new GraphPathFinder();
        
        // Create a sample graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        
        // Test path existence
        System.out.println("Path from 0 to 4: " + g.hasPath(0, 4));  // true
        System.out.println("Path from 1 to 4: " + g.hasPath(1, 4));  // true
        System.out.println("Path from 3 to 0: " + g.hasPath(3, 0));  // true
        
        // Create a disconnected node
        g.addEdge(5, 6);
        System.out.println("Path from 0 to 6: " + g.hasPath(0, 6));  // false
    }
}