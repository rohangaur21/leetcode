package array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
//Problem: Find the First and Last Position of an Element in a Sorted Array
//
//Given a sorted integer array nums and a target value target, find the starting and ending position of the target value in the array. If the target is not found, return [-1, -1].
//
//The array may contain duplicate elements, so we need to find both the first and last positions.
//
//Example:
//java
//        Copy
//Edit
//System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4, 5, 5, 5, 6, 6, 7}, 5)));
/// / Output: [4, 6]
//
//        System.out.println(Arrays.toString(searchRange(new int[]{-3, -2, -2, -2, -2, -1}, 0)));

/// / Output: [-1, -1]

public class FrstnLstPosSortedArr {

    // Main method to find the first and last position of the target
    public static int[] searchRange(int[] nums, int target) {
        // Check if the target exists using binary search
        if (Arrays.binarySearch(nums, target) < 0) {
            return new int[]{-1, -1}; // Target not found
        }

        // A TreeSet to store the indices of the target
        TreeSet<Integer> set = new TreeSet<>();

        // Perform a depth-first search to find all occurrences of target
        DFS(nums, set, 0, nums.length - 1, target);

        // Return the first and last position of target from the TreeSet
        if (set.size() > 0) {
            return new int[]{set.first(), set.last()};
        } else {
            return new int[]{-1, -1}; // No occurrence found
        }
    }

    // Depth-first search to find all indices of the target
    public static void DFS(int[] nums, Set<Integer> set, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) set.add(start);
            return;
        } else if (end - start == 1) {
            if (nums[start] == target) set.add(start);
            if (nums[end] == target) set.add(end);
            return;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            set.add(mid);
            if (nums[mid - 1] == target) {
                DFS(nums, set, start, mid - 1, target);
            }
            if (nums[mid + 1] == target) {
                DFS(nums, set, mid + 1, end, target);
            }
        } else if (nums[mid] < target) {
            DFS(nums, set, mid + 1, end, target);
        } else {
            DFS(nums, set, start, mid - 1, target);
        }
    }

    // Main function to test the above code
    public static void main(String[] args) {
        // Test with example arrays
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4, 5, 5, 5, 6, 6, 7}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{-3, -2, -2, -2, -2, -1}, 0)));
    }
}
