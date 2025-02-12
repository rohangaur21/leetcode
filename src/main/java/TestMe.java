import array.ThreeSum_EqToZero;

import java.util.Arrays;
import java.util.List;

public class TestMe {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    for(int i=0; i<nums.length; i++){
        if(nums[i]> 0) return
    }


    }




    public static void main(String... a) {
        // Create an instance of the ThreeSum_EqToZero class.
        ThreeSum_EqToZero s = new ThreeSum_EqToZero();

        // Test with a sample input.
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}
