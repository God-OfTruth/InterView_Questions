package GFG;

import java.util.Arrays;
import java.util.Collections;

public class SortIn012 {
    public static void main(String[] args) {
//        int[] arr = new int[]{0, 1, 0, 1, 2};
//        System.out.println(Arrays.toString(arr));
//        sort012(arr, 5);
//        System.out.println(Arrays.toString(arr));
        long[] a = new long[] {6,1,9,5,4};
        long[] b = new long[] {3,4,8,2,4};
        System.out.println(minValue(a, b, 5));
    }

    public static void sort012(int[] A, int n) {
        int i = 0, countzero = 0, countone = 0, counttwo = 0;
        while (i < n) {
            if (A[i] == 0) countzero = countzero + 1;
            else if (A[i] == 1) countone = countone + 1;
            else counttwo = counttwo + 2;
            i = i + 1;
        }
        for (i = 0; i < countzero; i++) A[i] = 0;
        for (i = countzero; i < countzero + countone; i++) A[i] = 1;
        for (i = countzero + countone; i < n; i++) A[i] = 2;
    }
    public static long minValue(long[] a, long[] b, long n) {
        Arrays.sort(a);
        int sum = 0;
        Arrays.sort(new long[][]{b}, Collections.reverseOrder());
        for(int i = 0; i< n; i++){
            sum += a[i] * b[i];
        }
        return sum;
    }
}
