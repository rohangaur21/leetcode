package array;

public class FindInRotatedSorted {
    public static void main(String... a) {
        System.out.println(search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 7));
    }

    static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;

        while (begin < end) {
            int mid = (begin + end) / 2;
            int num = (target < nums[0]) == (nums[mid] < nums[0])
                    ? nums[mid] :
                    (target < nums[0]) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

// 7 < 5 & 1 < 5 ? 1 : (7<5)?

            System.out.println(begin + "__ " + end + ", mid_x = " + mid + ", num[mid_x] = " + nums[mid] + "    __" + num);

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
