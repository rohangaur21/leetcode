package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int[] answer = new int[nums.length];

        // fill with product of left side.
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(answer));

        // fill with product of right side
        int R = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            System.out.print(answer[i]+"x"+R);
            answer[i] = answer[i] * R;
            R = R * nums[i];
            System.out.print("=>"+answer[i]+","+R+" ");
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("\n"+Arrays.toString(productExceptSelf(new int[]{2, 3, 4, 5})));
        //[24,12,8,6]
    }
}
