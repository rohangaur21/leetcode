public class FindInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            int num = (target < nums[0]) == (nums[mid] < nums[0])
                    ? nums[mid] :
                    (target < nums[0]) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target) {
                begin = mid + 1;
            } else if (num > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
