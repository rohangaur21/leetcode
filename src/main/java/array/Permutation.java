package array;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String... a) {
        System.out.println(new Permutation().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        dfs(nums, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> result) {
        if (nums.length == result.size()) {
            ans.add(new ArrayList<>(result));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
                dfs(nums, ans, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
