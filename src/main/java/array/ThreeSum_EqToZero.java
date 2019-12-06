package array;

import java.util.*;

public class ThreeSum_EqToZero {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int thirdNum;
        int thirdNumPos;
        Set<List<Integer>> setOfNums = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            for (int j = i + 1; j < nums.length - 1; j++) {
                thirdNum = 0 - (nums[i] + nums[j]);
                System.out.println(nums[i] + " " + nums[j] + " " + thirdNum);
                thirdNumPos = findPosWithBinarySearch(nums, j + 1, nums.length - 1, thirdNum);
                if (thirdNumPos > -1) {
                    List<Integer> toAdd = new LinkedList<>();
                    toAdd.add(nums[i]);
                    toAdd.add(nums[j]);
                    toAdd.add(thirdNum);
                    setOfNums.add(toAdd);
                }
            }
        }
        return new ArrayList<>(setOfNums);
    }

    public int findPosWithBinarySearch(int[] nums, int i, int j, int target) {
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
            }
        }
        return -1;
    }

    public static void main(String... a) {
        ThreeSum_EqToZero s = new ThreeSum_EqToZero();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //[[-1,-1,2],[-1,0,1]]
    }
}
