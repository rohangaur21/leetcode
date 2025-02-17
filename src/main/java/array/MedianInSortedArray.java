package array;

import java.util.Arrays;

/**
 * Problem Statement:
 * Given two sorted arrays nums1 and nums2 of size n and m respectively,
 * find the median of the merged sorted array.
 * The overall run time complexity should be O(n + m).
 * <p>
 * Example:
 * Input: nums1 = [1, 2, 3, 20], nums2 = [7, 10]
 * Output: 5.0
 * Explanation: The merged array is [1, 2, 3, 7, 10, 20].
 * The median is (3 + 7) / 2 = 5.0.
 */
public class MedianInSortedArray {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        int[] newArray = new int[nums1.length + nums2.length];

        for (int i = 0; i < tot; i++) {
            newArray[i] = i < nums1.length ? nums1[i] : nums2[i - nums1.length];
        }
        System.out.println(Arrays.toString(newArray));
        Arrays.sort(newArray);

        return tot % 2 == 0 ? (newArray[(tot / 2) - 1] + newArray[(tot / 2)]) / 2.0 : newArray[(tot) / 2];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 20};
        int[] arr2 = {7, 10};
        double d = new MedianInSortedArray().findMedianSortedArrays2(arr1, arr2);
        System.out.println(d);
    }
}
