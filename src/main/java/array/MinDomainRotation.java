package array;

import java.util.Arrays;

public class MinDomainRotation {
    /*
    Problem Statement:

    You are given two integer arrays A and B representing two rows of dominoes. Each domino has two numbers,
    and each number is represented by an integer. The task is to determine the minimum number of rotations required
    to make all the values in either row equal.

    - You can rotate a domino to make its top and bottom numbers the same.
    - In one rotation, you can swap the numbers in A[i] and B[i] for any index i.

    You need to implement a function minDominoRotations that returns the minimum number of rotations required to
    make all the numbers in either A or B the same. If it is not possible to achieve this, return -1.

    Constraints:
    - The length of arrays A and B are equal.
    - The elements of the arrays A and B are between 1 and 6, inclusive.

    Example:
    int[] A = {2, 1, 2, 4, 2, 2};
    int[] B = {5, 2, 6, 2, 3, 2};
    MinDomainRotation solver = new MinDomainRotation();
    int result = solver.minDominoRotations(A, B);
    System.out.println(result); // Output: 2

    Explanation:
    In this example, we need to find the minimum rotations required to make all values in either row equal.
    We can rotate the dominoes to make all the values equal to 2 with only 2 rotations, so the answer is 2.
    */

    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length)
            return -1;
        if (Arrays.equals(A, B))
            return 0;
        if (A.length == 1)
            return 0;

        boolean aFirstPresentInAll = findInArray(A[0], A, B);
        boolean bFirstPresentInAll = findInArray(B[0], A, B);

        int aMin = 0;
        if (aFirstPresentInAll) {
            for (int i = 1; i < A.length; i++) {
                if (A[0] != A[i])
                    aMin++;
            }
        }

        int bMin = 0;
        if (bFirstPresentInAll) {
            for (int i = 1; i < B.length; i++) {
                if (B[0] != B[i])
                    bMin++;
            }
        }

        if (aMin == 0 && bMin == 0)
            return -1;
        else if (aMin == 0)
            return bMin;
        else if (bMin == 0)
            return aMin;
        else
            return Math.min(aMin, bMin);
    }

    public boolean findInArray(int n, int[] arr_up, int[] arr_down) {
        for (int i = 1; i < arr_up.length; i++) {
            if (n != arr_up[i] && n != arr_down[i]) {
                return false;
            }
        }
        return true;
    }
}
