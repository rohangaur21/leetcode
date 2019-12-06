package array;

import java.util.*;

/*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new TreeSet<List<Integer>>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> l1, List<Integer> l2) {
                    int found = 0;
                    for (Integer i : l2) {
                        if (l1.contains(i)) {
                            found++;
                        }
                    }
                    System.out.println(l1.toString() + "__" + l2.toString() + "__" + (found == 3 ? 0 : -1));
                    return found == 3 ? 0 : -1;
                }
        });
        List<Integer> list = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        System.out.println("===");
                        ans.add(list);
                    }

                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String... a) {
        ThreeSum s = new ThreeSum();
        System.out.println(s.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }
}
