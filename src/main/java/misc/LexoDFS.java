package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

class LexoDFS {
    static boolean visited[];
    static Vector<Vector> adj = new Vector<Vector>();
    static List lexoDFS = new ArrayList<>();
    static void insertEdges(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static List<Integer> dfs(int src) {
        lexoDFS.add(src);
        visited[src] = true;
        //Iterate overall edges connected to the vertex
        for (int i = 0; i < adj.get(src).size(); i++) {
            if (!visited[(int) adj.get(src).get(i)])
                dfs((Integer) adj.get(src).get(i));

        }
        return lexoDFS;
    }
    public static List<Integer> lexdfs(int gNodxes, List<Integer> gFrom, List<Integer> gTo, List<Integer> r, List<Integer> v) {
        visited = new boolean[gNodxes + 1];
        List<Integer> lexoDFS = null;

        for (int i = 0; i < gNodxes + 1; i++) {
            adj.add(new Vector<>());
        }
        //insert the edges to the graph
        for (int i = 0; i < gFrom.size(); i++) {
            insertEdges(gFrom.get(i), gTo.get(i));
        }
        // Sorting in ascending order
        for (int i = 0; i < gNodxes; i++) {
            Collections.sort(adj.get(i));
        }
        for (int i = 0; i < gNodxes; i++) {
            if (!visited[i])
                lexoDFS = dfs(i);
        }
        //getting query results
        return lexoDFS;
    }

    // Driver code
    public static void main(String args[]) {
        List<Integer> gFrom = new ArrayList<>();
        gFrom.add(0);
        gFrom.add(3);
        gFrom.add(1);
        gFrom.add(0);
        gFrom.add(1);
        gFrom.add(2);
        List<Integer> gTo = new ArrayList<>();
        gTo.add(3);
        gTo.add(4);
        gTo.add(2);
        gTo.add(1);
        gTo.add(3);
        gTo.add(4);

        List<Integer> r = new ArrayList<>();
        r.add(0);
        r.add(3);
        r.add(2);
        r.add(1);
        List<Integer> v = new ArrayList<>();
        r.add(1);
        r.add(4);
        r.add(4);
        r.add(2);
        System.out.println(lexdfs(5, gFrom, gTo, r, v));
    }
}