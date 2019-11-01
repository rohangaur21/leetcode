package graph;

import java.util.List;

public class HasCycleDirectedGraphDFS {

    private static int N = 8;
    private static int count = 0;
    private static Graph graph;

    public static void main(String[] args) {
        graph = new AdjacencyMatrixGraph(N, Graph.GraphType.DIRECTED);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(7, 2);
        graph.addEdge(4, 7);
        graph.addEdge(4, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);
        System.out.println("\ngraph has cycle " + isCyclic(3));
    }

    private static boolean isCyclic() {
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];
        for (int i = 0; i < N; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }

    private static boolean isCyclic(int n) {
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];
        return isCyclicUtil(n, visited, recStack);
    }

    private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = graph.getAdjacentVertices(i);
        for (Integer c : children)
            return isCyclicUtil(c, visited, recStack);
        recStack[i] = false;
        return false;
    }
}
