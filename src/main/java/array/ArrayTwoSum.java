package array;

import java.util.*;

public class ArrayTwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int val = map.get(key);
                return new int[]{val, i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 10)));
    }
}
