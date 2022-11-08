package GFG;

import java.util.Arrays;

public class TransitionPoint {
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 0};
		System.out.println(transitionPoint(arr, arr.length));
	}

	static int transitionPoint(int[] arr, int n) {
		int start = 0, end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == 0) start = mid + 1;
			else if (arr[mid] == 1) {
				if (mid == 0 || arr[mid - 1] == 0)
					return mid;
				end = mid - 1;
			}
		}
		return -1;
	}
}
