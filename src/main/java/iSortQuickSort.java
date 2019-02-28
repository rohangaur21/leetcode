public class iSortQuickSort {
    public static void main(String... a) {
        int[] nums = new int[]{2, 3, 1, 0};
        sort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }

    }

    private static void sort(int[] nums, int begin, int end) {
        if (begin < end) {
            int pi = partition(nums, begin, end);
            sort(nums, begin, pi - 1);
            sort(nums, pi + 1, end);
        }
    }

    private static int partition(int[] nums, int begin, int end) {
        int pivot = nums[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
