package leet_code;

import java.util.Arrays;

public class _31 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 1, 5};
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		int index = -1;

		// Step 1: Find the first decreasing element from the end
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index = i;
				break;
			}
		}

		// Step 2: If no such element, array is in descending order — return the smallest (ascending order)
		if (index == -1) {
			reverse(nums, 0, n - 1);
			return;
		}

		// Step 3: Find element just larger than nums[index] from the end
		for (int i = n - 1; i > index; i--) {
			if (nums[i] > nums[index]) {
				swap(nums, i, index);
				break;
			}
		}

		// Step 4: Reverse the suffix starting from index+1
		reverse(nums, index + 1, n - 1);
	}

	private static void reverse(int[] nums, int left, int right) {
		while (left < right) {
			swap(nums, left++, right--);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
