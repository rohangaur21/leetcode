package array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArrayMultipleOfK {

    public static int subarraySum(int[] nums, int k) {
        // Map to store frequency of cumulative sum % k
        Map<Integer, Integer> modCount = new HashMap<>();
        // Initialize with modCount 0 = 1 to handle subarrays starting from index 0
        modCount.put(0, 1);

        int count = 0, sum = 0;

        for (int num : nums) {
            // Update the cumulative sum
            sum += num;

            // Find the modulo of the cumulative sum with respect to k
            int mod = sum % k;

            // Adjust mod to always be positive
            if (mod < 0) {
                mod += k;
            }

            // If the mod is already in the map, it means there's a subarray whose sum is a multiple of k
            if (modCount.containsKey(mod)) {
                count += modCount.get(mod);
            }

            // Update modCount with the new mod value
            modCount.put(mod, modCount.getOrDefault(mod, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test the method with a sample input
        System.out.println("\n" + subarraySum(new int[]{4, 5, 0, -2, -3, 1}, 5));  // Expected output: 7
    }
}


//Problem Statement: Continuous Subarray Sum Equals K
//Given:
//An integer array nums and an integer k.
//
//Task:
//Find the total number of continuous subarrays whose sum equals k.
//
//        Constraints:
//The subarray must be contiguous.
//The array may contain positive, negative, and zero values.
//The elements can be unsorted.
//        Input:
//An array nums of integers (1 ≤ nums.length ≤ 10⁵, -10⁴ ≤ nums[i] ≤ 10⁴).
//An integer k (-10⁷ ≤ k ≤ 10⁷).
//Output:
//An integer representing the number of subarrays that sum to k.
//        Example 1
//Input:
//java
//        Copy
//Edit
//        nums = {1, 2, 3, 4, 5, 6, 7};
//k = 9;
//Output:
//java
//        Copy
//Edit
//2
//Explanation:
//Valid subarrays:
//
//        [2, 3, 4] → 2 + 3 + 4 = 9
//        [4, 5] → 4 + 5 = 9