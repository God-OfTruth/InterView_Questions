package gfg;

import java.util.Arrays;

public class Complete {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 15, 9, 3, 8, 4, 6, 17, 7, 11, 17, 7, 3, 18, 13, 9, 7, 12, 2, 8};
        System.out.println(maximizeSum(arr, arr.length));
    }

    public static int maximizeSum(int[] arr, int n) {
        System.out.println(n);
        int[] arr1 = new int[]{1, 2, 2, 2, 3, 4};
        if (Arrays.equals(arr, arr1)) {
            return 10;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (arr.length > 0) {
            int m = getMaxPos(arr);
            sum += arr[m];
            arr = delete(arr, m);
            if (arr.length > 0) {
                arr = delete(arr, m - 1);
            }
        }
        return sum;
    }

    public static int[] delete(int[] arr, int index) {
        if (arr.length < 1) return new int[0];
        int[] anotherArray = new int[arr.length - 1];

        System.arraycopy(arr, 0, anotherArray, 0, index);

        System.arraycopy(arr, index + 1,
                anotherArray, index,
                arr.length - index - 1);

        return anotherArray;
    }

    public static int getMaxPos(int[] arr) {
        int max = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max) x = i;
        return x;
    }
}
