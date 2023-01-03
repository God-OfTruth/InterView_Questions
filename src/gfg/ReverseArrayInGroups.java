package gfg;

import java.util.Arrays;
import java.util.List;

public class ReverseArrayInGroups {
	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 4, 5};
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
		int k = 3;
		reverseInGroups(arr, arr.size(), k);
		System.out.println(arr);
	}

	static void reverseInGroups(List<Integer> arr, int n, int k) {
		for (int i = 0; i < n; i += k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);
			int temp;
			while (left < right) {
				temp = arr.get(left);
				arr.set(left, arr.get(right));
				arr.set(right, temp);
				left += 1;
				right -= 1;
			}
		}
	}
}
