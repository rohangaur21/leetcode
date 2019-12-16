import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        ans.add(new LinkedList<>(list));
        helper(ans, list, nums, 0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, int index) {
        for (int idx = index; idx < nums.length; idx++) {
            List<Integer> temp = new LinkedList<>(list);
            temp.add(nums[idx]);
            ans.add(temp);
            System.out.println(idx+"=>"+nums[idx]+" = "+temp.toString());
            helper(ans, temp, nums, idx + 1);
        }
    }

    public static void main(String... a) {
        System.out.println(new Subset().subsets2(new int[]{1, 2, 3}));
    }
}
