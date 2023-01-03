package gfg;

import java.util.Arrays;
import java.util.Collections;

public class SortIn012 {
	public static void main(String[] args) {
		long[] a = new long[]{6, 1, 9, 5, 4};
		long[] b = new long[]{3, 4, 8, 2, 4};
		System.out.println(minValue(a, b, 5));
	}

	public static long minValue(long[] a, long[] b, long n) {
		Arrays.sort(a);
		int sum = 0;
		Arrays.sort(new long[][]{b}, Collections.reverseOrder());
		for (int i = 0; i < n; i++) sum += a[i] * b[i];
		return sum;
	}
}
