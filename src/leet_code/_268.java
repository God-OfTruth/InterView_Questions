package leet_code;

import java.util.Arrays;

public class _268 {
	public static void main(String[] args) {

	}

	public int missingNumber(int[] nums) {
		int ans = nums.length;
		for (int i = 0; i < nums.length; i++) {
			ans ^= i ^ nums[i];
		}
		return ans;
	}
}
