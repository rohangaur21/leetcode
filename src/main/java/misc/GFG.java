package misc;


// Java program to find the lexicographically
// smallest traversal of a graph
import java.util.*;
class GFG
{

    static boolean visited[];
    static Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();

    // Utility function to add an
// edge to the graph
    static void insertEdges(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Function to perform DFS traversal
    static void dfs( int src, int n, int count)
    {
        // Print current vertex
        System.out.print( src + " ");
        count++;
        if(src == n){
            System.out.println("count "+(count-1));
        }

        // Mark it as visited
        visited[src] = true;

        // Iterate over all the edges connected
        // to this vertex
        for (int i = 0; i < adj.get(src).size(); i++)
        {
            // If this vertex is not visited,
            /// call dfs from this node
            if (!visited[adj.get(src).get(i)])
                dfs( adj.get(src).get(i), n, count);
        }
    }

    // Function to print the lexicographically
// smallest DFS
    static void printLexoSmall( int n)
    {
        // A boolean array to keep track of
        // nodes visited
        visited= new boolean[n + 1];

        // Sort the edges of each vertex in
        // ascending order
        for (int i = 0; i < n; i++)
            Collections.sort(adj.get(i));
        for (int i = 0; i < adj.size(); i++)
            System.out.println(i +" = "+adj.get(i));
        // Call DFS
//        for (int i = 1; i < n; i++)
//        {
//            if (!visited[i])
                dfs( 0, 24, 0);
//        }
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 29, m = 5;

        for(int i = 0; i < n + 1; i++)
            adj.add(new Vector<Integer>());
        List<Integer> gFrom = Arrays.asList(13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 0, 0, 0, 29, 3, 3);
        List<Integer> gTo = Arrays.asList(0, 29, 3, 10, 19, 2, 15, 6, 8, 4, 28, 11, 18, 25, 16, 12, 17, 26, 14, 22, 5, 7, 9, 20, 27, 1, 24, 23, 21);

        for(int i = 0; i < n ; i++){
            insertEdges(gFrom.get(i), gTo.get(i));
        }

        printLexoSmall( n);
    }
}