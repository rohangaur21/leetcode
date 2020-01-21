package misc;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
public class RainWaterTrap {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }

        int water = 0;
        int[] rightMax = new int[len];

        rightMax[len - 1] = height[len - 1];
        System.out.print(rightMax[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }


        int leftmax = Integer.MIN_VALUE;
        System.out.println("\n");
        for (int i = 0; i < len; i++) {
            leftmax = Math.max(leftmax, height[i]);
            System.out.print(leftmax);
            water += Math.min(leftmax, rightMax[i]) - height[i];
        }
        print(rightMax);
        print(height);

        return water;
    }

    public static void print(int[] nums) {
        System.out.println("\n");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
