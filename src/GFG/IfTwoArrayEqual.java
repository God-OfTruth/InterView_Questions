package GFG;

import java.util.Arrays;

public class IfTwoArrayEqual {
    public static void main(String[] args) {
        System.out.println(check(new long[]{1, 2, 5, 4, 0}, new long[]{2, 4, 5, 0, 1}, 5));
    }

    public static boolean check(long[] A, long[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < N; i++)
            if (A[i] != B[i]) return false;
        return true;
    }
}
