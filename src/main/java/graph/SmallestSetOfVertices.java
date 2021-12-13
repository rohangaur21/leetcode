package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestSetOfVertices {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(4, 2)
        );
        System.out.println("SmallestSetOfVertices = " + findSmallestSetOfVertices(n, edges));
    }

    static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] canBeReached = new boolean[n];

        for (List<Integer> li : edges) { // mark all the edges who have atleast one indegree i.e. incoming
            canBeReached[li.get(1)] = true; //1,2,5,4,2
        }

        for (int i = 0; i < n; i++)      // add all those edges, having 0 indegree
            if (!canBeReached[i])
                res.add(i);
        return res;
    }
}
