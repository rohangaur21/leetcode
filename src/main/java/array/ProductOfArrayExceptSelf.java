package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /*
    Problem Statement:

    Given an array `nums` of n integers, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

    Example:
    Input: nums = [2, 3, 4, 5]
    Output: [24, 12, 8, 6]
    Explanation:
    The product of all elements except `nums[i]` is:
    - answer[0] = 3 * 4 * 5 = 60
    - answer[1] = 2 * 4 * 5 = 40
    - answer[2] = 2 * 3 * 5 = 30
    - answer[3] = 2 * 3 * 4 = 24

    Note:
    - The solution should not use the division operation.
    - You must solve it in O(n) time complexity and O(1) space complexity (excluding the space for the output array).

    Constraints:
    - n == nums.length
    - 2 <= n <= 10^4
    - -30 <= nums[i] <= 30
    - The answer is guaranteed to be fit within the range of a 32-bit integer.
    */

    private static int[] productExceptSelf(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Fill the answer array with the left products
        answer[0] = 1; // The first element has no left product
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        System.out.println(Arrays.toString(answer));

        // Step 2: Multiply the right products directly into the answer array
        int rightProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct *= nums[i + 1];
            answer[i] *= rightProduct; // Multiply right product with the current value
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println("\n" + Arrays.toString(productExceptSelf(new int[]{2, 3, 4, 5})));
        //[24, 12, 8, 6]
    }
}
