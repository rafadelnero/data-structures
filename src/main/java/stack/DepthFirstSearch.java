package stack;

import java.util.*;

public class DepthFirstSearch {

    // Graph representation using adjacency list
    private Map<Integer, List<Integer>> adjList;

    public DepthFirstSearch() {
        this.adjList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // For undirected graph
    }

    // Perform DFS traversal
    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(startNode, visited);
    }

    // Recursive DFS helper function
    private void dfsHelper(int node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        // Mark the node as visited and print it
        visited.add(node);
        System.out.print(node + " ");

        // Traverse all adjacent nodes
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            dfsHelper(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch graph = new DepthFirstSearch();

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("DFS Traversal starting from node 0:");
        graph.dfs(0);
    }
}