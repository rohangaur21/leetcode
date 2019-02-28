import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class iArrFrstnLstPosSortedArr {
    public static int[] searchRange(int[] nums, int target) {
        if (Arrays.binarySearch(nums, target) < 0) {
            return new int[]{-1, -1};
        }
        TreeSet<Integer> set = new TreeSet<>();
        DFS(nums, set, 0, nums.length - 1, target);
        if (set.size() > 0) {
            return new int[]{set.first(), set.last()};
        } else {
            return new int[]{-1, -1};
        }
    }

    public static void DFS(int[] nums, Set<Integer> set, int start, int end, int target) {

        if (start == end) {
            if (nums[start] == target) set.add(start);
            return;
        } else if (end - start == 1) {
            if (nums[start] == target) set.add(start);
            if (nums[end] == target) set.add(end);
            return;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            set.add(mid);
            if (nums[mid - 1] == target) {
                DFS(nums, set, start, mid - 1, target);
            }
            if (nums[mid + 1] == target) {
                DFS(nums, set, mid + 1, end, target);
            }
        } else if (nums[mid] < target) {
            DFS(nums, set, mid + 1, end, target);
        } else {
            DFS(nums, set, start, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4, 5, 5, 5, 6, 6, 7}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{-3, -2, -2, -2, -2, -1}, 0)));
    }
}
