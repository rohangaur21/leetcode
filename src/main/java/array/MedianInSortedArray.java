package array;

import java.util.Arrays;

public class MedianInSortedArray {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        int[] newArray = new int[nums1.length + nums2.length];

        for (int i = 0; i < tot; i++) {
            newArray[i] = i < nums1.length ? nums1[i] : nums2[i - nums1.length];
        }
        Arrays.sort(newArray);

        return tot % 2 == 0 ? (newArray[(tot / 2) - 1] + newArray[(tot / 2)]) / 2.0 : newArray[(tot) / 2];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 == 0 && n2 == 0) {
            return 0d;
        } else if (n2 == 0) {
            return (n1 % 2 > 0) ? nums1[(n1 / 2)] : (nums1[(n1 / 2) - 1] + nums1[n1 / 2]) / 2.0;
        } else if (n1 == 0) {
            return (n2 % 2 > 0) ? nums2[(n2 / 2)] : (nums2[(n2 / 2) - 1] + nums2[n2 / 2]) / 2.0;
        } else {
            int[] nums = new int[n1 + n2];
            int i = 0, j = 0, k = 0;
            while (k < (n1 + n2)) {
                if (i < n1 && j < n2 && nums1[i] <= nums2[j]) {
                    nums[k] = nums1[i++];
                } else if (j < n2) {
                    nums[k] = nums2[j++];
                }
                k++;
            }
            int n3 = nums.length;
            return (n3 % 2 > 0) ? nums[(n3 / 2)] : (nums[(n3 / 2) - 1] + nums[n3 / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 20};
        int[] arr2 = {7, 10};
        double d = new MedianInSortedArray().findMedianSortedArrays(arr1, arr2);
        System.out.println(d);
    }
}
