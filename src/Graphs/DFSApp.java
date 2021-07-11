package Graphs;

import java.util.Stack;

// Обход графа в глубину
public class DFSApp {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.print("Visits: ");
        dfs(graph);
    }

    private static void dfs(Graph graph) {
        Stack<Integer> stack = new Stack<>();

        graph.vertexList[0].wasVisited = true;
        graph.displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                graph.vertexList[v].wasVisited = true;
                graph.displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < graph.nVerts; i++) {
            graph.vertexList[i].wasVisited = false;
        }
    }
}
