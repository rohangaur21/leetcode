package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum_EqToTarget {

    /**
     * Problem Statement:
     * <p>
     * Given a list of integers `nums` and an integer `target`, you need to find two distinct indices
     * in the list such that the numbers at those indices add up to the `target`.
     * <p>
     * You should return the indices of the two numbers such that they sum up to the `target`. Assume that
     * each input has exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * <p>
     * Input:
     * nums = [2, 7, 11, 15]
     * target = 9
     * <p>
     * Output:
     * [0, 1]  // Because nums[0] + nums[1] == 9 (2 + 7 = 9)
     * <p>
     * Explanation:
     * In this example, the target is 9. The pair of numbers that sum to 9 is 2 and 7, which are at indices 0 and 1.
     * The method will return the indices [0, 1] (0-indexed).
     *
     * @param nums:   a list of integers (length 2 ≤ n ≤ 10^4)
     * @param target: the target integer (1 ≤ target ≤ 10^9)
     * @return: a list of two indices where nums[i] + nums[j] = target
     */
    public static List<Integer> twoSum(List<Integer> nums, int target) {
        // Map to store the numbers we have already seen and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through the list to find two numbers that add up to the target
        for (int i = 0; i < nums.size(); i++) {
            // Calculate the number needed to reach the target
            int key = target - nums.get(i);

            // If the complementary number is in the map, return the indices
            if (map.containsKey(key)) {
                // Found the solution, return the indices of the two numbers
                return Arrays.asList(map.get(key), i);
            }

            // Store the current number and its index in the map
            map.put(nums.get(i), i);
        }

        // If no solution is found, return an empty list (this should not happen per problem statement)
        return Arrays.asList(-1, -1); // Indicates no solution (if input is incorrect)
    }

    public static void main(String[] args) {
        // Run tests
        testTwoSum();
    }

    // Test method to validate the twoSum function
    public static void testTwoSum() {
        // Test 1: Basic test case
        List<Integer> nums1 = Arrays.asList(2, 7, 11, 15);
        int target1 = 9;
        System.out.println("Test 1: " + (twoSum(nums1, target1).equals(Arrays.asList(0, 1)) ? "Passed" : "Failed"));

        // Test 2: Case with negative numbers
        List<Integer> nums2 = Arrays.asList(-1, -2, -3, -4, -5);
        int target2 = -8;
        System.out.println("Test 2: " + (twoSum(nums2, target2).equals(Arrays.asList(2, 3)) ? "Passed" : "Failed"));

        // Test 3: No solution case
        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4, 5);
        int target3 = 10;
        System.out.println("Test 3: " + (twoSum(nums3, target3).equals(Arrays.asList(-1, -1)) ? "Passed" : "Failed"));

        // Test 4: Test case with larger target and larger array
        List<Integer> nums4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int target4 = 18;
        System.out.println("Test 4: " + (twoSum(nums4, target4).equals(Arrays.asList(7, 9)) ? "Passed" : "Failed"));

        // Test 5: Case with identical numbers
        List<Integer> nums5 = Arrays.asList(3, 3, 4, 4);
        int target5 = 7;
        System.out.println("Test 5: " + (twoSum(nums5, target5).equals(Arrays.asList(0, 3)) ? "Passed" : "Failed"));
    }
}
