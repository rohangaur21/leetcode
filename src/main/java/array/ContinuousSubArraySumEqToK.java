package array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySumEqToK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum == k) {
                ans++;
                System.out.println("found");
            }
            System.out.println("i = "+i+", sum = "+ sum +", sum-("+k+") = "+ (sum-k)+", "+map);
            ans += map.getOrDefault(sum-k, 0); // remove excess sum in past with sum-k
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println("\n" + subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
    }
}

//k = sum + t => t = k - sum,