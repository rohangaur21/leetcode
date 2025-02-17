package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem Statement:
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example:
 * Input: intervals = [[8,10], [1,3], [2,6], [15,18]]
 * Output: [[1,6], [8,10], [15,18]]
 * Explanation: Intervals [1,3] and [2,6] overlap and are merged into [1,6].
 * The other intervals remain unchanged.
 * <p>
 * Constraints:
 * - The input is an array of intervals where each interval is represented as [start, end].
 * - The intervals may not be sorted.
 * - The solution should be efficient with a time complexity of O(n log n).
 */
public class MergeIntervals {
    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        System.out.println(Arrays.deepToString(intervals));

        List<int[]> list = new ArrayList<>();
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
        for (int[] i : merge(new int[][]{{8, 10}, {1, 3}, {2, 6}, {15, 18}}))
            System.out.println(Arrays.toString(i));
    }
}
