package gfg;

import java.util.Arrays;

public class ToZigZag {
	public static void main(String[] args) {
		int[] arr = {4, 3, 7, 8, 6, 2, 1};
		System.out.println(Arrays.toString(arr));
		zigZag(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void zigZag(int[] arr, int n) {
		boolean flag = true;
		int temp;
		for (int i = 0; i <= n - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag;
		}
	}
}
