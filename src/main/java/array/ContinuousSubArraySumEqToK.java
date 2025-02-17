package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Continuous Subarray Sum Equals k
 * <p>
 * Given an integer array `nums` and an integer `k`, find the number of contiguous subarrays whose sum equals `k`.
 * <p>
 * Constraints:
 * - The array may contain positive, negative, and zero values.
 * - 1 ≤ nums.length ≤ 10⁵, -10⁴ ≤ nums[i] ≤ 10⁴, -10⁷ ≤ k ≤ 10⁷.
 */
public class ContinuousSubArraySumEqToK {

    private static int subarraySum(int[] nums, int k) {
        // Map to store the frequency of prefix sums
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // Initialize map with 0 sum having 1 occurrence (to handle subarrays starting from index 0)
        prefixSumCount.put(0, 1);

        int count = 0, sum = 0;

        // Iterate through the array
        for (int num : nums) {
            sum += num; // Calculate the running sum

            // Check if there's a prefix sum that when subtracted from the current sum equals k
            count += prefixSumCount.getOrDefault(sum - k, 0);

            // Update the map with the current sum's frequency
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count; // Return the count of subarrays whose sum equals k
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Example array
        int k = 9; // Target sum
        System.out.println("Total subarrays with sum " + k + " = " + subarraySum(nums, k)); // Expected output: 3
    }
}
