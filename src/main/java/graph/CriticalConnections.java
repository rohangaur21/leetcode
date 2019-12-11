package graph;

import java.util.*;

public class CriticalConnections {
    Map<Integer, List<Integer>> graph;
    boolean[] isVisited;
    List<List<Integer>> result;

    private int[] dist;
    private int[] low;
    private int[] parent;
    private int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new HashMap<>();
        isVisited = new boolean[n];
        result = new LinkedList<>();

        dist = new int[n];
        low = new int[n];
        parent = new int[n];
        time = 0;

        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<>());
            parent[i] = -1;
        }
        for (List<Integer> conn : connections) {
            int a = conn.get(0);
            int b = conn.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (Integer i : graph.keySet()) {
            System.out.println(i + " : " + graph.get(i).toString());
        }

        dfs(0);
        return result;
    }

    private void dfs(int root) {
        if (isVisited[root]) {
            return;
        }
        isVisited[root] = true;
        dist[root] = time;
        low[root] = time;
        time++;
        for (Integer neighbor : graph.get(root)) {
            if (!isVisited[neighbor]) {
                parent[neighbor] = root;
                dfs(neighbor);
                low[root] = Math.min(low[root], low[neighbor]);
                if (dist[root] < low[neighbor]) {
                    result.add(Arrays.asList(root, neighbor));
                }
            } else if (neighbor != parent[root]) {
                low[root] = Math.min(low[root], dist[neighbor]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new LinkedList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));


        System.out.println(new CriticalConnections().criticalConnections(n, connections));
    }
}
