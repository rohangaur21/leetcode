import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    public List<List> subsets1(int[] nums) {
        int n = nums.length;
        List<List> ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            List list = new ArrayList<>();
            int index = i;
            int bit = 0;
            while (index > 0) {
                if ((index & 1) == 1) list.add(nums[bit]);
                index >>= 1;
                bit++;
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        ans.add(new LinkedList<>(list));
        helper(ans, list, nums, 0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, int i) {
        for (int j = i; j < nums.length; j++) {
            List<Integer> temp = new LinkedList<>(list);
            temp.add(nums[j]);
            ans.add(temp);
            helper(ans, temp, nums, j + 1);
        }
    }

    public static void main(String... a) {
        System.out.println(new Subset().subsets2(new int[]{1, 2, 3}));
    }
}
