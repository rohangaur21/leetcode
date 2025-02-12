package array;

import java.util.*;

public class ThreeSum_EqToZero {

    /**
     * The problem is to find all unique triplets in the array that sum up to zero.
     * <p>
     * Problem Statement:
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     *
     * @param nums: An array of integers.
     * @return A list of lists, where each list contains three integers that sum to zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the array to easily avoid duplicates and efficiently find triplets.
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // For debugging: Print the sorted array.

        // Step 2: Prepare a set to store unique triplets (to avoid duplicate triplets in the result).
        Set<List<Integer>> setOfNums = new HashSet<>();

        // Step 3: Iterate through the array to pick the first number of the triplet.
        for (int i = 0; i < nums.length - 2; i++) {
            // Step 4: Skip duplicate numbers to avoid checking the same triplet.
            if (nums[i] > 0)
                break; // If the current number is positive, break the loop. No need to check further, as the sum can't be zero.

            // Step 5: Iterate to find the second number of the triplet.
            for (int j = i + 1; j < nums.length - 1; j++) {
                // Step 6: Calculate the third number, which should be the negative sum of the current two numbers.
                int thirdNum = 0 - (nums[i] + nums[j]);
                System.out.println(nums[i] + " " + nums[j] + " " + thirdNum); // Debug: Print the current pair and required third number.

                // Step 7: Find the third number's position using binary search (starting from index j + 1).
                int thirdNumPos = findPosWithBinarySearch(nums, j + 1, nums.length - 1, thirdNum);

                // Step 8: If the third number exists (i.e., it's found), add the triplet to the set.
                if (thirdNumPos > -1) {
                    List<Integer> toAdd = new LinkedList<>();
                    toAdd.add(nums[i]);
                    toAdd.add(nums[j]);
                    toAdd.add(thirdNum);
                    setOfNums.add(toAdd); // The set will automatically avoid duplicates.
                }
            }
        }

        // Step 9: Convert the set to a list and return it as the final result.
        return new ArrayList<>(setOfNums);
    }

    /**
     * Binary search to find the target in the subarray from index i to j.
     *
     * @param nums:   The sorted array.
     * @param i:      The starting index for the search.
     * @param j:      The ending index for the search.
     * @param target: The number to search for.
     * @return The index of the target in the subarray, or -1 if it's not found.
     */
    public int findPosWithBinarySearch(int[] nums, int i, int j, int target) {
        int mid;
        // Step 1: While the search range is valid (i <= j)
        while (i <= j) {
            mid = (i + j) / 2; // Find the mid point.

            if (nums[mid] == target) {
                return mid; // Found the target, return its index.
            } else if (nums[mid] > target) {
                j = mid - 1; // Target is smaller, search in the left half.
            } else {
                i = mid + 1; // Target is larger, search in the right half.
            }
        }

        // Step 2: If the target is not found, return -1.
        return -1;
    }

    /**
     * Main method to test the ThreeSum function.
     */
    public static void main(String... a) {
        // Create an instance of the ThreeSum_EqToZero class.
        ThreeSum_EqToZero s = new ThreeSum_EqToZero();

        // Test with a sample input.
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}
