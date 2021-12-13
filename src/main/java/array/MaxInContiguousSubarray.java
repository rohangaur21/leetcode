package array;

import java.util.Arrays;

public class MaxInContiguousSubarray {
    static int maxSubarray(int[] arr) {
        int[] temp = new int[arr.length];
        int max = arr[0];
        temp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp[i] = Math.max(arr[i], arr[i] + temp[i - 1]); //Store max between current & (current + previousStored)
            max = Math.max(max, temp[i]);                     // Get max of stored max
        }
        System.out.println(Arrays.toString(temp));
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(maxSubarray(arr));
    }
}
