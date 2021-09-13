package top100;

import java.util.ArrayList;
import java.util.Stack;

/**
 * DAG using dfs implements.
 * https://www.geeksforgeeks.org/topological-sorting/
 */
public class Graph {

    int V;
    ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSortHelper(int v, boolean visited[], Stack<Integer> stack) {

        visited[v] = true;

        for(Integer i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSortHelper(i, visited, stack);
            }
        }

        stack.push(v);
    }

    void topologicalSort() {

        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[adj.size()];

        for(int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortHelper(i, visited, stack);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological "
                           + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
    
}
