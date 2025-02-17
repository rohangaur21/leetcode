package array;

import java.util.Arrays;

public class ArrayTest {

    private static int[] productExceptSelf(int[] nums) {
        System.out.println(Arrays.toString(nums));

        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        System.out.println(Arrays.toString(answer));
        int right = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            answer[i] = answer[i] * right;
        }
        return answer;

    }


    public static void main(String[] args) {
        System.out.println("\n" + Arrays.toString(productExceptSelf(new int[]{2, 3, 4, 5})));
        //[24, 12, 8, 6]
    }

}
