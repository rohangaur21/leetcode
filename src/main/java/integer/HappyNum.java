package integer;

import java.util.ArrayList;
import java.util.List;

public class HappyNum {
    public boolean isHappy(int n) {
        return dfs(new ArrayList<Integer>(), n);
    }

    public boolean dfs(List<Integer> nums, int n) {
        if (n == 1)
            return true;
        if (nums.contains(n))
            return false;
        nums.add(n);

        int newNum = 0;
        int num = 0;
        while (n > 0) {
            num = n % 10;
            newNum += num * num;
            n = n / 10;
        }
        return dfs(nums, newNum);
    }
}
