package leet_code;

import java.util.ArrayList;
import java.util.List;

public class _2597 {
	static int res;
	static List<Integer> subset;

	public static void main(String[] args) {

		System.out.println(beautifulSubsets(new int[]{2, 4, 6}, 2));
	}

	public static int beautifulSubsets(int[] nums, int k) {
		res = 0;
		subset = new ArrayList<>();
		backtrack(0, nums, k);
		return res;
	}

	private static void backtrack(int i, int[] nums, int k) {
		if (i == nums.length) {
			if (!subset.isEmpty()) {
				res++;
			}
			return;
		}
		boolean isValid = true;
		for (int num : subset) {
			if (Math.abs(num - nums[i]) == k) {
				isValid = false;
				break;
			}
		}

		if (isValid) {
			subset.add(nums[i]);
			backtrack(i + 1, nums, k);
			subset.remove(subset.size() - 1);
		}
		backtrack(i + 1, nums, k);
	}
}
