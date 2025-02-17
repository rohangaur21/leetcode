package array;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /*
    Problem Statement:

    Given an array of distinct integers, return all possible permutations of the array.
    You can return the answer in any order.

    Example 1:
    Input: [1, 2, 3]
    Output:
    [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

    Example 2:
    Input: [0, 1]
    Output: [[0, 1], [1, 0]]

    Example 3:
    Input: [1]
    Output: [[1]]

    Constraints:
    - The input array length will be between 1 and 6.
    - The elements of the input array are distinct integers.
    */

    public static void main(String... a) {
        System.out.println(new Permutation().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        dfs(nums, results, new ArrayList<>());
        return results;
    }

    public void dfs(int[] nums, List<List<Integer>> results, List<Integer> res) {
        if (nums.length == res.size()) {
            results.add(new ArrayList<>(res));
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + " .. " + results + " = " + res);
            if (!res.contains(nums[i])) {
                res.add(nums[i]);
                dfs(nums, results, res);
                res.remove(res.size() - 1);
            }
        }
    }
}
