package leet_code;

import java.util.Arrays;

public class _75 {
	public static void main(String[] args) {
		int[] arr = new int[]{2,0,2,1,1,0};
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, mid, low);
				low++;
				mid++;
			}
			else if (nums[mid] == 1) {
				mid++;
			}
			else if (nums[mid] == 2) {
				swap(nums, mid, high);
				high--;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
