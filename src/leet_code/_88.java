package leet_code;

import java.util.Arrays;

public class _88 {
	public static void main(String[] args) {
		int[] nums = new int[]{0};
		merge(nums, 0, new int[]{2}, 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int x = m - 1, y = n - 1;
		for (int i = nums1.length - 1; i >= 0 && y >= 0; i--) {
			if (x >= 0 && nums1[x] > nums2[y]) {
				nums1[i] = nums1[x];
				x--;
			} else {
				nums1[i] = nums2[y];
				y--;
			}
		}
	}
}
