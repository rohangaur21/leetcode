package array;

public class SubArrayExceedsSum {

    /*
    Problem Statement:

    Given an array `arr` of positive integers, you are to find the length of the smallest contiguous subarray whose sum exceeds a given integer `k`. If no such subarray exists, return -1.

    Example:
    Input: arr = [1, 3, 4, 5, 6], k = 12
    Output: 3
    Explanation:
    The smallest subarray with a sum greater than 12 is [4, 5, 6] which has length 3.

    Constraints:
    - The array contains positive integers only.
    - If no subarray's sum exceeds `k`, return -1.
    - The time complexity should be optimized if possible.
    */

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6};
        int min_sum = 12;
        System.out.println(getMinSubArrayExceedsSum(arr, min_sum));
    }

    private static int getMinSubArrayExceedsSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int sum;
        int count;

        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            count = 1;
            for (int j = i + 1; j < arr.length; j++) { // Start from j = i + 1 to avoid redundant summation
                sum += arr[j];
                count++;
                if (sum > k) {
                    min = Math.min(count, min);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min; // Return -1 if no subarray is found
    }
}
