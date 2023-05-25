package leet_code;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int[] nums2 = {2, 5, 6};
//		merge(nums1, 3, nums2, nums2.length);
		System.out.println(removeDuplicates(nums1));
//		System.out.println(Arrays.toString(nums1));

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;     // nums1's index (actual nums)
		int j = n - 1;     // nums2's index
		int k = m + n - 1; // nums1's index (next filled position)

		while (j >= 0)
			if (i >= 0 && nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
	}

	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int num : nums)
			if (i < 1 || num > nums[i - 1])
				nums[i++] = num;
		return i;
	}
}
