package array;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
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
            System.out.println(i +" .. "+results+" = "+res);
            if (!res.contains(nums[i])) {
                res.add(nums[i]);
                dfs(nums, results, res);
                res.remove(res.size() - 1);
            }
        }
    }
}
