package array;

import java.util.Arrays;

public class MinDomainRotation {
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
