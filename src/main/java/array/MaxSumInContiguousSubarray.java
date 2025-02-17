package array;

import java.util.Arrays;

/**
 * This class finds the maximum sum of a contiguous subarray within a given integer array.
 * It uses Kadane's Algorithm to efficiently compute the result in O(n) time complexity.
 */
public class MaxSumInContiguousSubarray {

    /**
     * Finds the maximum sum of any contiguous subarray.
     *
     * @param arr Input array of integers
     * @return Maximum sum of a contiguous subarray
     */
    private static int maxSubarray(int[] arr) {
        int[] temp = new int[arr.length];
        int max = arr[0];
        temp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            temp[i] = Math.max(arr[i], arr[i] + temp[i - 1]); // Store max between current & (current + previous)
            max = Math.max(max, temp[i]);                     // Update max sum found so far
        }

        System.out.println("DP Array: " + Arrays.toString(temp)); // Debugging output
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Maximum Sum of Contiguous Subarray: " + maxSubarray(arr));
    }
}
