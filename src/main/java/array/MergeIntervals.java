package array;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int size = list.size();
            if (list.isEmpty() || list.get(size - 1)[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                list.get(size - 1)[1] = Math.max(list.get(size - 1)[1], intervals[i][1]);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        for(int [] i: merge(new int[][]{{8,10},{1,3},{2,6},{15,18}}))
            System.out.println(Arrays.toString(i));
    }
}
