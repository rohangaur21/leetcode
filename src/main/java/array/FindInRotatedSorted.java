package array;
//Problem: Find Target in Rotated Sorted Array
//
//Given a rotated sorted array nums and a target value, find the index of the target using binary search. If the target is not found, return -1. The array is originally sorted in ascending order but is then rotated at some pivot.
//
//        Example:
//
//Input: nums = [5, 6, 7, 0, 1, 2, 3, 4], target = 7

public class FindInRotatedSorted {
    public static void main(String... a) {
        // Example: Rotated sorted array, target = 7
        System.out.println(search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 7)); // Output should be 2
    }

    static int search(int[] nums, int target) {
        int begin = 0; // Starting index
        int end = nums.length - 1; // Ending index

        // While the search space is valid
        while (begin <= end) {
            int mid = (begin + end) / 2; // Mid index

            System.out.println("Begin: " + begin + ", End: " + end + ", Mid: " + mid + ", Mid Value: " + nums[mid]);

            // Check if mid element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[begin] <= nums[mid]) {
                // Target lies in the left half
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else { // Right half is sorted
                // Target lies in the right half
                if (nums[mid] < target && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }
}
