package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySumEqToK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i : nums) {
            sum += i;
            ans += map.getOrDefault(sum - k, 0);
            if (sum == k) ans++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            printMap(sum - k,map);
        }

        return ans;
    }

    static void printMap(int tag, Map<Integer, Integer> map) {
        System.out.print("\n" + tag + "=> ");
        for (Integer i : map.keySet()) {
            System.out.print(i + "-" + map.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n" + subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
    }
}
