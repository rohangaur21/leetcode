package misc;


// Java program to find the lexicographically
// smallest traversal of a graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GFGLexo {

    static boolean visited[];
    static List<List<Integer>> adj = new ArrayList<List<Integer>>();
    static List<Integer> lexoDFS = new ArrayList<>();

    static void insertEdges(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static Integer dfs(int src, int dest, int count) {
        System.out.println("move = "+src+" -> "+ dest +" count = "+count);
        if(src == dest) {
            System.out.println("======================found");
            return count;
        }else{
            visited[src] = true;
            //Iterate overall edges connected to the vertex
            Integer res = null;
            for (int i = 0; i < adj.get(src).size(); i++) {
                System.out.println(adj.get(src).get(i)+" visit? "+visited[ adj.get(src).get(i)]);
                if (!visited[ adj.get(src).get(i)])
                    res = dfs( adj.get(src).get(i), dest, ++count);
                System.out.println("res -> "+res);
                if(res != null) return res;
            }
            return res;
        }
    }

    public static List<Integer> lexdfs(int gNodxes, List<Integer> gFrom, List<Integer> gTo, List<Integer> r, List<Integer> v) {
        visited = new boolean[gNodxes + 1];
        List<Integer> lexoDFS = null;
        for (int i = 0; i < gNodxes + 1; i++) {
            adj.add(new ArrayList<Integer>());
        }
        //insert the edges to the graph
        for (int i = 0; i < gFrom.size(); i++) {
            insertEdges(gFrom.get(i), gTo.get(i));
        }

        // Sorting in ascending order
        for (int i = 0; i < gNodxes; i++) {
            Collections.sort(adj.get(i));
        }

        System.out.println(gNodxes);
        System.out.println(gFrom);
        System.out.println(gTo);

        System.out.println(r);
        System.out.println(v);
        System.out.println("==============");
        for(int i=0;i<adj.size();i++){
            System.out.println(i +" = "+adj.get(i));
        }
        System.out.println("==============");
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < r.size(); i++) {
            visited = new boolean[gNodxes + 1];
            int res = dfs(r.get(i), v.get(i), 0);
            result.add(res);
        }
        return result;
    }


    // Driver code
    public static void main(String args[]) {
        int gNodxes = 29;
        List<Integer> gFrom = Arrays.asList(13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 0, 0, 0, 29, 3, 3);
        List<Integer> gTo = Arrays.asList(0, 29, 3, 10, 19, 2, 15, 6, 8, 4, 28, 11, 18, 25, 16, 12, 17, 26, 14, 22, 5, 7, 9, 20, 27, 1, 24, 23, 21);
        List<Integer> r = Arrays.asList(0, 2, 3, 4, 2, 1, 2, 2, 3, 4, 3, 2, 5, 1, 5, 5, 1, 1, 2, 2, 1, 1, 5, 1, 3, 1, 0, 3, 3, 1, 3, 0, 4, 1, 1, 2, 4, 4, 1, 5, 3, 5, 1, 5, 1, 4, 1, 0, 5, 1, 5, 4, 3, 2, 1, 5, 2, 3, 2, 2, 1, 4, 1, 0, 0, 4, 0, 5, 0, 1, 4, 0, 5, 3, 0, 0, 3, 3, 0, 2, 1, 3, 1, 1, 0, 3, 1, 5, 3, 5, 1, 2, 2, 0, 0, 5, 5, 5, 0, 4);
        List<Integer> v = Arrays.asList(18, 12, 8, 4, 10, 24, 11, 27, 25, 2, 23, 11, 28, 3, 19, 21, 21, 0, 8, 11, 22, 16, 8, 11, 28, 19, 24, 7, 20, 21, 5, 20, 26, 21, 17, 19, 23, 2, 23, 26, 25, 23, 26, 29, 16, 15, 21, 29, 8, 14, 29, 15, 9, 14, 19, 18, 14, 19, 27, 26, 28, 7, 18, 17, 10, 9, 3, 20, 22, 20, 26, 2, 26, 16, 3, 18, 18, 21, 3, 4, 11, 18, 4, 6, 7, 5, 15, 4, 17, 19, 21, 25, 8, 21, 9, 13, 5, 2, 21, 13);


//        List<Integer> gFrom = Arrays.asList(0,1,2,3,4,5,6,7,8);
//        List<Integer> gTo = Arrays.asList  (1,2,3,2,2,4,6,7,8);
//        List<Integer> r = Arrays.asList( 1);
//        List<Integer> v = Arrays.asList( 5);

        System.out.println("ANS "+lexdfs(gNodxes, gFrom, gTo, r, v));
        System.out.println(gFrom.size()+" "+gTo.size());
        System.out.println(r.size()+" "+v.size());
    }
}