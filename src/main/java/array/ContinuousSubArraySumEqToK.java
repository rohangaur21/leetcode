package array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySumEqToK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Handles cases where sum itself is k
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num; // Running sum
            count += prefixSumCount.getOrDefault(sum - k, 0); // Check for (sum - k) in the map
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1); // Store/update sum frequency
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 9;
        System.out.println("Total subarrays with sum " + k + " = " + subarraySum(nums, k));
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