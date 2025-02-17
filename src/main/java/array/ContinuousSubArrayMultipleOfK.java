package array;

import java.util.Arrays;

/**
 * Problem: Continuous Subarray Sum Equals a Multiple of k
 * <p>
 * Given an integer array `nums` and an integer `k`, find the number of contiguous subarrays
 * whose sum is a multiple of `k`.
 * <p>
 * Constraints:
 * - The array may contain positive, negative, and zero values.
 * - 1 ≤ nums.length ≤ 10⁵, -10⁴ ≤ nums[i] ≤ 10⁴, -10⁷ ≤ k ≤ 10⁷.
 * <p>
 * Example:
 * Input: nums = {4, 5, 0, -2, -3, 1}, k = 5
 * Output: 5
 * <p>
 * Explanation:
 * The valid subarrays (of length ≥ 2) whose sum is a multiple of 5 are:
 * - [4, 5, 0, -2, -3, 1]  → 4+5+0-2-3+1 = 5
 * - [5, 0]               → 5+0 = 5
 * - [5, 0, -2, -3]       → 5+0-2-3 = 0
 * - [0, -2, -3]          → 0-2-3 = -5
 * - [-2, -3]             → -2-3 = -5
 */

public class ContinuousSubArrayMultipleOfK {
    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        // Loop over all possible starting indices
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            // For each starting index, try all subarrays of length >= 2
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test the method with a sample input
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays whose sum is a multiple of " + k + ": " + result);
    }
}
