package WeightedGraphs;

// Выбор кратчайшего пути в направленном взвешанном графе
public class PathApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A'); // 0 (start)
        graph.addVertex('B'); // 2
        graph.addVertex('C'); // 1
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addEdge(0, 1, 50); // AB 50
        graph.addEdge(0, 3, 80); // AD 80
        graph.addEdge(1, 2, 60); // BC 60
        graph.addEdge(1, 3, 90); // BD 90
        graph.addEdge(2, 4, 40); // CE 40
        graph.addEdge(3, 2, 20); // DC 20
        graph.addEdge(3, 4, 70); // DE 70
        graph.addEdge(4, 1, 50); // EB 50
        System.out.println("Shortest paths");
        graph.path();
        System.out.println();
    }
}

class DistPar {
    public int distance;
    public int parentVert;

    public DistPar(int pv, int d) {
        distance = d;
        parentVert = pv;
    }
}

class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
        label = lab;
        isInTree = false;
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int nTree;
    private DistPar[] sPath;
    private int currentVert;
    private int startToCurrent;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
        sPath = new DistPar[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }

        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;
            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }

            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
        }
        displayPaths();
        nTree = 0;
        for (int j = 0; j < nVerts; j++)
            vertexList[j].isInTree = false;
    }

    public int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for (int j = 1; j < nVerts; j++) {
            if (!vertexList[j].isInTree &&
                    sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }

    public void adjust_sPath() {
        int column = 1;
        while (column < nVerts) {
            if (vertexList[column].isInTree) {
                column++;
                continue;
            }

            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;

            if (startToFringe < sPathDist) {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if (sPath[j].distance == INFINITY)
                System.out.print("inf");
            else
                System.out.print(sPath[j].distance);
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println();
    }
}