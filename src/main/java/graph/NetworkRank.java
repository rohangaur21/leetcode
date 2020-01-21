package graph;

import java.util.*;

public class NetworkRank {
    public static void main(String[] args) {
        System.out.println(countEdges(new int[]{1, 2, 3, 3}, new int[]{2, 3, 1, 4}, 4));
//        System.out.println(countEdges(new int[]{1, 2, 4, 5}, new int[]{2, 3, 5, 6}, 6));
    }

    public static int countEdges(int[] A, int[] B, int N) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
            return 0;
        }

        //Form an adjacency list
        Map<Integer, List<Integer>> network = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!network.containsKey(A[i])) {
                network.put(A[i], new ArrayList<Integer>());
            }
            if (!network.containsKey(B[i])) {
                network.put(B[i], new ArrayList<Integer>());
            }
            network.get(A[i]).add(B[i]);
            network.get(B[i]).add(A[i]);
        }

        System.out.println("All cities network starts");
        for (Integer i : network.keySet()) {
            System.out.println(i + " => " + network.get(i).toString());
        }
        System.out.println("All cities network ends");

        // Iterate through all nodes and perform DFS on the node not present in seen set
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for (int j = 1; j <= N; j++) {
            int edges = dfs(network, seen, j);
            res = Math.max(res, edges);
        }
        // Since each edge is counted twice in the dfs method we return res/2
        return res / 2;
    }

    public static int dfs(Map<Integer, List<Integer>> network, Set<Integer> seen, int city) {
        if (!network.containsKey(city) || seen.contains(city)) {
            return 0;
        }
        seen.add(city);
        List<Integer> nodes = network.get(city);
        int res = nodes.size();
        for (Integer node : nodes) {
            res += dfs(network, seen, node);
        }
        return res;
    }
}
