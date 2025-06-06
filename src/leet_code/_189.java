package leet_code;

import java.util.Arrays;

public class _189 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	public static void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
