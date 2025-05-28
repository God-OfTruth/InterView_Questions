package leet_code;

import java.util.Arrays;

public class _169 {
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{3, 2, 3}));
	}

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int ans = 0;
		int temp = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				temp++;
			} else {
				temp = 0;
			}
			ans = Math.max(ans, temp);
		}
		return nums[ans];
	}
}
