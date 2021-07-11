package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// Обход графа в ширину
public class BFSApp {
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
        bfs(graph);
    }

    private static void bfs(Graph graph) {
        Queue<Integer> queue = new ArrayDeque<>();

        graph.vertexList[0].wasVisited = true;
        graph.displayVertex(0);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();

            while ((v2 = graph.getAdjUnvisitedVertex(v1)) != -1) {
                graph.vertexList[v2].wasVisited = true;
                graph.displayVertex(v2);
                queue.add(v2);
            }
        }

        for (int i = 0; i < graph.nVerts; i++) {
            graph.vertexList[i].wasVisited = false;
        }
    }
}
