package leet_code;

import java.util.Arrays;

public class _2149 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
	}

	public static int[] rearrangeArray(int[] nums) {
		int posIndex = 0;
		int negIndex = 1;
		int[] ans = new int[nums.length];
		for (int num : nums) {
			if (num > 0) {
				ans[posIndex] = num;
				posIndex += 2;
			} else {
				ans[negIndex] = num;
				negIndex += 2;
			}
		}
		return ans;
	}
}
