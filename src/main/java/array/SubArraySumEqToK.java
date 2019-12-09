package array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqToK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i : nums) {
            sum += i;
            ans += map.getOrDefault(sum - k, 0);
            if (sum == k) ans++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
