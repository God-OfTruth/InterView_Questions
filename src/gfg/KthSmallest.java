package gfg;

import java.util.Arrays;

public class KthSmallest {
	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 3, 20, 15};
		int k = 3;
		System.out.println(kthSmallest(arr, 0, arr.length - 1, k));
	}

	public static int kthSmallest(int[] arr, int l, int r, int k) {
		Arrays.sort(arr);
		return arr[k-1];
	}
}
