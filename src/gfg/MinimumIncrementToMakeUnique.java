package gfg;

import java.util.Arrays;

public class MinimumIncrementToMakeUnique {
	public static void main(String[] args) {
		int[] arr = {4, 5, 4, 1, 3, 7, 6, 3, 3};
		System.out.println(minIncrements(arr, arr.length));
	}

	public static long minIncrements(int[] arr, int n) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 1; i < n; i++)
			if (arr[i - 1] >= arr[i]) {
				count += arr[i - 1] - arr[i] + 1;
				arr[i] = arr[i - 1] + 1;
			}
		return count;
	}
}
