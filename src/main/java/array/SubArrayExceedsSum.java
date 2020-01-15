package array;

public class SubArrayExceedsSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6};
        int min_sum = 12;
        System.out.println(getMinSubArrayExceedsSum(arr, min_sum));
    }

    private static int getMinSubArrayExceedsSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int sum;
        int count;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            count = 1;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                count++;
                if (sum > k) {
                    min = Math.min(count, min);
                    break;
                }
            }
        }
        return min;
    }
}
